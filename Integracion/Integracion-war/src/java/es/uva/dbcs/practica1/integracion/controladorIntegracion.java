/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.integracion;

import es.uva.dbcs.practica1.despliegue.CompCatalogoControladorRemote;
import es.uva.dbcs.practica1.despliegue.CompPedidoControladorLocal;
import es.uva.dbcs.practica1.despliegue.CompUsuarioControladorLocal;
import es.uva.dbcs.practica1.dominio.Configuracionpc;
import es.uva.dbcs.practica1.dominio.Descripcioncomponente;
import es.uva.dbcs.practica1.dominio.Empleado;
import es.uva.dbcs.practica1.dominio.Empresa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Javier
 */
@WebServlet(name = "controladorIntegracion", urlPatterns = {"/controladorIntegracion"})
public class controladorIntegracion extends HttpServlet {
    @EJB
    private CompPedidoControladorLocal cPedido;
    @EJB
    private CompCatalogoControladorRemote cCatalogo;
    @EJB
    private CompUsuarioControladorLocal cUsuario;

    
    private String accederEmpleado(HttpSession session, HttpServletRequest request){
        String nifcif = request.getParameter("NifCif");
        String clave = request.getParameter("clave");
        String url = "index.jsp";
        String mensaje = "";
        Empleado empleado = cUsuario.getEmpleado(nifcif);
        if(empleado!=null){
            boolean claveCorrecta = clave.equals(empleado.getUsuario().getPassword());
            if(claveCorrecta){
                url = "empleado.jsp";
            }else{
                mensaje = "Clave incorrecta";
            }
        }else{
            mensaje = "No existe un empleado con ese nifcif";
        }
        session.setAttribute("mensaje", mensaje);
        session.setAttribute("nifcif", nifcif);
        return url;
    }
    
    private String accederCliente(HttpSession session, HttpServletRequest request){
        String nifcif = request.getParameter("NifCif");
        String clave = request.getParameter("clave");
        String url = "index.jsp";
        String mensaje = "";
        Empresa empresa = cUsuario.getEmpresa(nifcif);
        if(empresa!=null){
            boolean claveCorrecta = clave.equals(empresa.getUsuario().getPassword());
            if(claveCorrecta){
                url = "cliente.jsp";
            }else{
                mensaje = "Clave incorrecta";
            }
        }else{
            mensaje = "No existe un cliente con ese nifcif";
        }
        session.setAttribute("mensaje", mensaje);
        session.setAttribute("nifcif", nifcif);
        return url;
    }
    
    private String nuevaConfiguracion(HttpSession session, HttpServletRequest request){
        // Cadena vacia == 0 ?
        int velCPU = Integer.valueOf(request.getParameter("velocidad"));
        int capRAM = Integer.valueOf(request.getParameter("ram"));
        int capDD = Integer.valueOf(request.getParameter("dd"));
        int memTarGraf = Integer.valueOf(request.getParameter("memGraf"));
        int velTarGraf = Integer.valueOf(request.getParameter("velGraf"));
        short idTipoCPU = Short.valueOf(request.getParameter("tipoCPU"));
        String componentes[] = request.getParameterValues("componentes");
        List<Integer> idsDescrComp = new ArrayList();
        for(String comp : componentes){
            idsDescrComp.add(Integer.valueOf(comp));
        }
        boolean exito = cCatalogo.addConfiguracion(velCPU, capRAM, capDD, velTarGraf, memTarGraf, idTipoCPU, idsDescrComp);
        String url = "empleado.jsp";
        String mensaje;
        if(exito)
            mensaje = "Operación realizada con éxito";
        else
            mensaje = "Error al realizar la última operación";
        session.setAttribute("mensaje", mensaje);
        return url;
    }
    
    private String editarConfiguracion(HttpSession session, HttpServletRequest request){
        
        int idConf = Integer.valueOf(request.getParameter("idConf"));
        int velCPU = Integer.valueOf(request.getParameter("velocidad"));
        int capRAM = Integer.valueOf(request.getParameter("ram"));
        int capDD = Integer.valueOf(request.getParameter("dd"));
        int memTarGraf = Integer.valueOf(request.getParameter("memGraf"));
        int velTarGraf = Integer.valueOf(request.getParameter("velGraf"));
        short idTipoCPU = Short.valueOf(request.getParameter("tipoCPU"));
        
        boolean exito = cCatalogo.editConfiguracion(idConf, velCPU, capRAM, capDD, velTarGraf, memTarGraf, idTipoCPU);       
        String url = "empleado.jsp";
        String mensaje;
        if(exito)
            mensaje = "Operación realizada con éxito";
        else
            mensaje = "Error al realizar la última operación";
        session.setAttribute("mensaje", mensaje);
        return url;
    }
    
    private String salir(HttpSession session, HttpServletRequest request){
        String url = "index.jsp";
        session.invalidate();
        return url;
    }
    
    private String hacerPedido(HttpSession session, HttpServletRequest request){
        List<Configuracionpc> catalogo = cCatalogo.getCatalogo();
        float precios[] = new float[catalogo.size()];
        for(int i = 0; i < precios.length; i++){
            precios[i] = cCatalogo.getPrecioTotal(catalogo.get(i).getIdconfiguracion());
        }
        session.setAttribute("mensaje", "");
        session.setAttribute("catalogo", catalogo);
        session.setAttribute("precios", precios);
        return "pedido.jsp";
    }
    
    private String borrarPedido(HttpSession session, HttpServletRequest request){
        session.setAttribute("mensaje", "");
        return "borrarPedido.jsp";
    }
    
    private String importePedidosCompletados(HttpSession session, HttpServletRequest request){
        String nifcif = (String) session.getAttribute("nifcif");
        float imp = cPedido.importeAbonar(nifcif);
        session.setAttribute("pago", imp);
        return "importeAbonar.jsp";
    }

    private String comprar(HttpSession session, HttpServletRequest request){
        
        String nifcif = (String) session.getAttribute("nifcif");
        // try catch aqui
        int idConf = Integer.valueOf(request.getParameter("idConf"));
        int cantidad = Integer.valueOf(request.getParameter("cantidad"));
        boolean exito = cPedido.addPedido(cantidad, idConf, nifcif);
        String mensaje;
        if(exito){
            mensaje = "Compra realizada con exito";
        }else{
            mensaje = "Error en la realización de la compra";
        }
        session.setAttribute("mensaje", mensaje);
        return "cliente.jsp";
    }
    
    private String eliminar(HttpSession session, HttpServletRequest request) {
        int idConf = Integer.valueOf(request.getParameter("idConf"));
        String nifcif = (String) session.getAttribute("nifcif");
        boolean exito = cPedido.delPedido(idConf, nifcif);
        String mensaje;
        if(exito){
            mensaje = "Pedido borrado con exito";
        }else{
            mensaje = "Error en el borrado del pedido";
        }
        session.setAttribute("mensaje", mensaje);
        return "cliente.jsp";
    }
    
    private String volver(HttpSession session, HttpServletRequest request) {
        return "cliente.jsp";
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String boton = request.getParameter("envio");
        String url;
        session.setAttribute("mensaje", "");
        switch(boton){
            case "Acceder Empleado":
                url = accederEmpleado(session, request);
                break;
            case "Acceder Cliente":
                url = accederCliente(session, request);
                break;
            case "Nueva Configuracion":
                url = nuevaConfiguracion(session, request);
                break;
            case "Editar Configuracion":
                url = editarConfiguracion(session, request);
                break;
            case "Salir":
                url = salir(session, request);
                break;
            case "Hacer Pedido":
                url = hacerPedido(session, request);
                break;
            case "Borrar Pedido":
                url = borrarPedido(session, request);
                break;
            case "Importe Pedidos Completados":
                url = importePedidosCompletados(session, request);
                break;
            case "Comprar":
                url = comprar(session, request);
                break;
            case "Eliminar":
                url = eliminar(session, request);
                break;
            /*case "Volver":
                url = volver(session, request);
                break;*/
            default:
                url = "index.jsp";
        }
        
        response.sendRedirect(url);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
