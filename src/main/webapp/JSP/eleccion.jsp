<%-- 
    Document   : eleccion
    Created on : 10-dic-2021, 10:52:52
    Author     : Manuel Guillén Gallardo
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Presupuesto</title>
        <style><%@include file="../CSS/estilo.css"%></style>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>
    <body class="body__app">
        <c:set var="idioma" value="${sessionScope.idiomaElegido}" scope="application" />
        <fmt:setLocale value="${idioma}" scope="application" />
        <header>
            <div class="container__logo">
                <span class="material-icons">
                    roofing
                </span>
                <a href="../index.jsp"><h1>Roof</h1></a>
            </div>
            <div class="navbar">

            </div>
        </header>
        <main class="main__eleccion">
            <fmt:bundle basename="${idioma}">
                <!--<img src="../IMAGENES/familia.jpg" />-->
                <form action="${pageContext.request.contextPath}/Eleccion" method="POST" class="form__eleccion">
                    <h2 id="eleccion__legend"><fmt:message key ="eleccion__legend" /></h2>
                    <p id="eleccion__txt"><strong><fmt:message key ="eleccion__txt" />:</strong></p>
                    <div>
                        <input type="checkbox" name="chkEleccion" id="chkContinente" value="chkContinente" ${sessionScope.eleccionBean.continente==1 || sessionScope.eleccionBean == null?'checked="checked"':''} />
                        <label for="chkContinente">
                            <fmt:message key ="chkContinente" />
                        </label>
                        <input type="checkbox" name="chkEleccion" id="chkContenido" value="chkContenido" ${sessionScope.eleccionBean.contenido==2 || sessionScope.eleccionBean == null?'checked="checked"':''} />
                        <label for="chkContenido">
                            <fmt:message key ="chkContenido" />
                        </label>
                    </div>
                    <button type="submit" name="continuar" value="continuar" class="btn">CONTINUAR</button>
                </form>
            </fmt:bundle>
        </main>

    </body>
</html>
