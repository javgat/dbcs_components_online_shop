<%-- 
    Document   : cliente
    Created on : 22-oct-2020, 20:08:20
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
        <h1><%= session.getAttribute("mensaje")%></h1>
        <% session.setAttribute("pagina", "cliente"); %>
        <h2>Escoja opción</h2>
        <form action="controladorIntegracion" name="ejemplo" method="get">
            <input type="submit" value="Hacer Pedido" name="envio"> <br>
            <input type="submit" value="Borrar Pedido" name="envio"> <br>
            <input type="submit" value="Importe Pedidos Completados" name="envio"><br>
            <input type="submit" value="Salir" name="envio"><br>
        </form>
    </body>
</html>
