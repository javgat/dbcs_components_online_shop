<%-- 
    Document   : ImportaAbonar
    Created on : 23-oct-2020, 19:33:13
    Author     : cevp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TiendaPC Cliente</title>
    </head>
    <body>
        <!-- El atributo mensaje se usara para mostrar avisos al usuario, por ejemplo
             el resultado de una operacion -->
        <h2>Importe a abonar por pedidos completados</h2>
        <p>Importe: <%= session.getAttribute("pago") %></p>
        <form action="cliente.jsp" name="ejemplo" method="get">
            <input type="submit" value="Volver">
        </form>
    </body>
</html>
