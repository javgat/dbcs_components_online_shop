<%-- 
    Document   : borrarPedido
    Created on : 23-oct-2020, 19:09:19
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
            Id Configuracion: <input type="text" name="idConf">
            <input type="submit" value="Eliminar" name="envio">
        </form>
    </body>
</html>
