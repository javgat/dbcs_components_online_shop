/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.prueba;

import es.uva.dbcs.practica1.despliegue.CompUsuarioControladorLocal;
import es.uva.dbcs.practica1.dominio.Empleado;
import es.uva.dbcs.practica1.dominio.Empresa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Javier
 */
@WebServlet(name = "pruebaCompUsuario", urlPatterns = {"/pruebaCompUsuario"})
public class pruebaCompUsuario extends HttpServlet {
    @EJB
    private CompUsuarioControladorLocal cUC;

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
        Empresa empresaNull = cUC.getEmpresa("NoExiste");
        Empresa empresaNoNull = cUC.getEmpresa("111111U");
        Empleado empleadoNull = cUC.getEmpleado("NoExiste");
        Empleado empleadoNoNull = cUC.getEmpleado("444444U");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet pruebaCompUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet pruebaComp Usuario at Pruebas CompUsuario </h1>");
            out.println("<h2>Operacion getEmpresa: <h2>");
            out.println("<p> valor retornado no existe: " + empresaNull + "</p>");
            out.println("<p> usuario existente 11111U. Valor campo esCliente: " 
                    + empresaNoNull.getEscliente().toString() + "</p>");
            out.println("<h2>Operacion getEmpleado: <h2>");
            out.println("<p> valor retornado no existe: " + empleadoNull + "</p>");
            out.println("<p> usuario existente 444444U. Valor campo fecha: " 
                    + empleadoNoNull.getFechacontratacion().toString() + "</p>");
            out.println("<p> usuario existente 444444U. Rol:" +
                    empleadoNoNull.getRol().getNombrerol() + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
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
