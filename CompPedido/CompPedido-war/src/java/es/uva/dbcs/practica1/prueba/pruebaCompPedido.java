/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.dbcs.practica1.prueba;

import es.uva.dbcs.practica1.despliegue.CompPedidoControladorRemote;
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
@WebServlet(name = "pruebaCompPedido", urlPatterns = {"/pruebaCompPedido"})
public class pruebaCompPedido extends HttpServlet {
    @EJB
    private CompPedidoControladorRemote fachadaCompPedido;

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
        
        float resImporteAbonar_Err = fachadaCompPedido.importeAbonar("NoExiste");
        float resImporteAbonar_NoErr_ConCompletados = fachadaCompPedido.importeAbonar("111111U");
        float resImporteAbonar_NoErr_SinCompletados = fachadaCompPedido.importeAbonar("555555U");
        
        Boolean resAddPedido_Err = fachadaCompPedido.addPedido(3, 8888, "555555U"); // esa configuracion no existe
        Boolean resAddPedido_NoErr = fachadaCompPedido.addPedido(3, 3333, "555555U");
        
        Boolean resDelPedido_Err = fachadaCompPedido.delPedido(4444, "555555U"); // no hay ningun pedido de ese usuario con esa configuracion
        Boolean resDelPedido_NoErr = fachadaCompPedido.delPedido(2222, "555555U");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet pruebaCompPedido</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet prueba componente Pedido</h1>");
            out.println("<h2>*** Prueba importeAbonar: </h2>" );
            out.println("<p> con error. respuesta: " + resImporteAbonar_Err + "</p>");
            out.println("<p> sin error con completados. respuesta: " + resImporteAbonar_NoErr_ConCompletados + "</p>");
            out.println("<p> sin error sin completados. respuesta: " + resImporteAbonar_NoErr_SinCompletados + "</p>");
            out.println("<h2>*** Prueba addPedido: </h2>" );
            out.println("<p>con error en idPedido. Respuesta: " + resAddPedido_Err + "</p>");
            out.println("<p>sin error. Respuesta: " + resAddPedido_NoErr + "</p>");
            out.println("<h2>*** Prueba delPedido: </h2>" );
            out.println("<p>con error debido a que no hay ningún pedido del usuario en la tabla con esa configuracion. Respuesta: " + resDelPedido_Err + "</p>");
            out.println("<p>sin error. Respuesta: " + resDelPedido_NoErr + "</p>");
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
