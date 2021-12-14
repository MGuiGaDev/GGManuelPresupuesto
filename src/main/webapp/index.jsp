<%-- 
    Document   : index.jsp
    Created on : 10-dic-2021, 11:36:56
    Author     : Manuel Guillén Gallardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Presupuesto</title>
        <style><%@include file="CSS/estilo.css"%></style>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <body>
        <main class="main__idioma">
            <div class="title__idioma">
                <span class="material-icons">
                    roofing
                </span>
                <h1>Roof</h1>
            </div>
            <form action="${pageContext.request.contextPath}/Idioma" class="form__idioma" method="POST">
                <p>IDIOMA | LANGUAGE</p>
                <div>
                    <button class="btn__idioma" name="idiomaElegido" value="es_ES" id="es"></button>
                    <button class="btn__idioma" name="idiomaElegido" value="en_GB" id="en"></button>
                </div>
            </form>
        </main>
    </body>
</html>
