/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.integracion;

import es.uva.dbcs.practica1.despliegue.CompCatalogoControladorRemote;
import es.uva.dbcs.practica1.despliegue.CompPedidoControladorLocal;
import es.uva.dbcs.practica1.despliegue.CompUsuarioControladorLocal;
import es.uva.dbcs.practica1.dominio.Empleado;
import es.uva.dbcs.practica1.dominio.Empresa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        String boton = request.getParameter("boton");
        String url;
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
            default:
                url = "index.jsp";
        }
        /*
        String usuario = (String) session.getAttribute("sessionUser")
        */
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
