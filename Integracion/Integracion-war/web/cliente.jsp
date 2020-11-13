<%-- 
    Document   : cliente
    Author     : cevp, modificado por javgato y javmoro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TiendaPC Cliente</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
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
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    </body>
</html>
