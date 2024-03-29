<%-- 
    Document   : empleado
    Created on : 22-oct-2020, 20:07:53
    Author     : cevp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TiendaPC Empleado</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
        <!-- El atributo mensaje se usara para mostrar avisos al empleado, por ejemplo
             el resultado de una operacion -->
        <h1><%= session.getAttribute("mensaje")%></h1>
        <% session.setAttribute("pagina", "empleado");%>
        <form action="controladorIntegracion" name="ejemplo" method="post">
            <h2>Rellene configuracion</h2>
            Id configuracion (solo para editar): <input type="text" name="idConf"><br><br>
            velocidad CPU: <input type="text" name="velocidad"><br><br>
            Capacidad RAM: <input type="text" name="ram"><br><br>
            Capadidad DD: <input type="text" name="dd"><br><br>
            Memoria tarjeta gráfica: <input type="text" name="memGraf"><br><br>
            Velocidad tarjeta gráfica: <input type="text" name="velGraf"><br><br>
            <h2>Tipo CPU</h2>
            <input type="radio" name="tipoCPU" value="1">AMD<br>
            <input type="radio" name="tipoCPU" value="2" checked>Intel<br>
            <h2>Escoja Componentes (Solo Nueva)</h2>
            <select name="componentes" size="9" multiple>
                <table>
                    <tr>
                        <td><option value="111"></td>
                        <td> Tipo: 1 </td>
                        <td> Marca: marca 1 </td>
                        <td> Modelo: modelo 1 </td>
                        </tr>
                    <tr>
                        <td> <option value="222"></td>
                        <td> Tipo: 2 </td>
                        <td> Marca: marca 1 </td>
                        <td> Modelo: modelo 2 </td>
                        </tr>
                    <tr>
                        <td> <option value="333"></td>
                        <td> Tipo: 3 </td>
                        <td> Marca: marca 2 </td>
                        <td> Modelo: modelo 3 </td>
                        </tr>
                    <tr>
                        <td> <option value="444"></td>
                        <td> Tipo: 4 </td>
                        <td> Marca: marca 5 </td>
                        <td> Modelo: modelo 4 </td>
                        </tr>
                    <tr>
                        <td> <option value="555"></td>
                        <td> Tipo: 5 </td>
                        <td> Marca: marca 5 </td>
                        <td> Modelo: modelo 5 </td>
                        </tr>
                    <tr>
                        <td> <option value="666"></td>
                        <td> Tipo: 6 </td>
                        <td> Marca: marca 6 </td>
                        <td> Modelo: modelo 6 </td>
                        </tr>
                    <tr>
                        <td> <option value="777"></td>
                        <td> Tipo: 1 </td>
                        <td> Marca: marca 7 </td>
                        <td> Modelo: modelo 7 </td>
                        </tr>
                    <tr>
                        <td> <option value="888"></td>
                        <td> Tipo: 2 </td>
                        <td> Marca: marca 5 </td>
                        <td> Modelo: modelo 8 </td>
                        </tr>
                    <tr>
                        <td> <option value="999"></td>
                        <td> Tipo: 3 </td>
                        <td> Marca: marca 8 </td>
                        <td> Modelo: modelo 8 </td>
                        </tr>
                </table>
            </select>
            <br><br>
            <input type="submit" value="Nueva Configuracion" name="envio"><br><br><!-- name era envio-->
            <input type="submit" value="Editar Configuracion" name="envio"><br><br>
            <input type="reset" value="Vaciar">
            <input type="submit" value="Salir" name="envio"><br><br>
        </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    </body>
</html>

