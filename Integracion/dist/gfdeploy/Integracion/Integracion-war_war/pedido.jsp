<%-- 
    Document   : pedido
    Created on : 23-oct-2020, 13:51:22
    Author     : cevp
--%>

<%@page import="es.uva.dbcs.practica1.dominio.Configuracionpc"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TiendaPC Pedido</title>
    </head>
    <body>
        <h1><%= session.getAttribute("mensaje")%></h1>
        <% session.setAttribute("pagina", "cliente"); %>
        <h2>Escoja configuración</h2>
            <% List<Configuracionpc> catalogo = (List<Configuracionpc>) session.getAttribute("catalogo"); %>
            <% float[] precios = (float []) session.getAttribute("precios"); %>
        
            <table>
                <% for(int i=0; i<precios.length; i++) { %>
                <form action="controladorIntegracion" name="ejemplo" method="get">
                <tr>
                    <td>Configuracion <%= i%></td>
                    <td>velocidad CPU: <%= catalogo.get(i).getVelocidadcpu() %> </td>
            <td>, Capacidad RAM: <%= catalogo.get(i).getCapacidadram() %> </td>
            <td>, Capadidad DD: <%= catalogo.get(i).getCapacidaddd() %> </td>
            <td>, Memoria tarjeta gráfica: <%= catalogo.get(i).getMemoriatarjetagrafica() %> </td>
            <td>, Velocidad tarjeta gráfica: <%= catalogo.get(i).getVelocidadtarjetagrafica() %> </td></td>
            <td>, Tipo CPU: <%= catalogo.get(i).getTipocpu().getNombretipocpu() %> </td></td>
            <td>, Precio: <%= precios[i] %></td>
                <input type="hidden" value="<%= catalogo.get(i).getIdconfiguracion() %>" name="idConf">
            <td>, Cantidad: <input type="text" name="cantidad"> <input type="submit" value="Comprar" name="envio"></td>
                </tr>
                </form>
                <% } %>
            </table>
    </body>
</html>
