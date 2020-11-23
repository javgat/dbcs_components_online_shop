<%-- 
    Document   : index
    Created on : 12-nov-2020, 11:55:03
    Author     : Javier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TiendaPC</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
        <% if (session.isNew()) {%>
        <% session.setAttribute("pagina", "index");} %>
        <% if(session.getAttribute("mensaje")!=null){%>
        <h1><%= session.getAttribute("mensaje")%> </h1>
        <%}%>
        <p>Introduce nombre cif y clave</p>
        <form action="controladorIntegracion" name="ejemplo" method="get">
            NIF: <input type="text" name="NifCif"><br>
            Password: <input type="password" name="clave"><br><br>
        <input type="submit" name="envio" value="Acceder Empleado">
        <input type="submit" name="envio" value="Acceder Cliente">
        <input type="reset" value="Vaciar">
        </form>
        <!-- Mediante el atributo "mensaje" mostramos los errores o indicaciones
             que consideremos en cada caso -->
        
        </div>
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    </body>
</html>