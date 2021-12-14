<%-- 
    Document   : contenido
    Created on : 10-dic-2021, 10:41:15
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
    </head>
    <c:set var="idioma" value="${sessionScope.idiomaElegido}" scope="application" />
    <fmt:setLocale value="${idioma}" scope="application" />
    <body>
        <header>
            <div class="container__logo">
                <span class="material-icons">
                    roofing
                </span>
                <a href="${pageContext.request.contextPath}/index.jsp"><h1>Roof</h1></a>
            </div>
            <div class="navbar">

            </div>
        </header>
        <main class="main__eleccion">
            <fmt:bundle basename="${idioma}">
                <c:set var="contenidoCookie" value="${sessionScope.contenidoCookie}" />
                <form action="${pageContext.request.contextPath}/Contenido" method="POST" class="form__eleccion">
                    <div class="form__header">
                        <h2 id="contenido__legend"><fmt:message key ="contenido__legend" /></h2>
                        <p id="contenido__text"><strong><fmt:message key ="contenido__text" /></strong></p>
                    </div>
                    <div class="container__input">
                        <label for="capitalAsegurado"><fmt:message key ="capitalAsegurado" />:</label>
                        <select name="capitalAsegurado" id="capitalAsegurado">
                            <option value="10000" ${contenidoCookie.capitalAsegurado==10000? 'selected="selected"':''}><fmt:formatNumber type="currency" value="10000"/></option>
                            <option value="20000" ${contenidoCookie.capitalAsegurado==20000? 'selected="selected"':''}><fmt:formatNumber type="currency" value="20000"/></option>
                            <option value="30000" ${contenidoCookie.capitalAsegurado==30000? 'selected="selected"':''}><fmt:formatNumber type="currency" value="30000"/></option>
                            <option value="50000" ${contenidoCookie.capitalAsegurado==50000? 'selected="selected"':''}><fmt:formatNumber type="currency" value="50000"/></option>
                            <option value="100000"  ${contenidoCookie.capitalAsegurado==100000 || contenidoCookie == null? 'selected="selected"':''}><fmt:formatNumber type="currency" value="100000"/></option>
                        </select>
                    </div>
                    <div class="container__input">
                        <label><fmt:message key ="franquicia" />:</label>
                        <input type="radio" name="franquicia" id="fNinguna" value="0" ${contenidoCookie.franquicia==0 || contenidoCookie == null? 'checked':''}/>
                        <label for="fNinguna"><fmt:message key ="franquicia__options" /></label>
                        <input type="radio" name="franquicia" id="fMedia" value="0.1" ${contenidoCookie.franquicia==0.1? 'checked':''}/>
                        <label for="fMedia"><fmt:formatNumber type="currency" value="500"/></label>
                        <input type="radio" name="franquicia" id="fAlta" value="0.2" ${contenidoCookie.franquicia==0.2? 'checked':''}/>
                        <label for="fAlta"><fmt:formatNumber type="currency" value="1000" /></label>
                    </div>
                    <div class="container__input">
                        <input type="checkbox" name="seguroAccidente" id="seguroAccidente" value="true" ${contenidoCookie.seguroAccidente==true || contenidoCookie == null? 'checked':''}/>
                        <label for="seguroAccidente"><fmt:message key ="seguroAccidente" /></label>
                    </div>
                    <button type="submit" name="continuar" value="continuar" class="btn"><fmt:message key ="btn__continuar"/></button>
                </form>
            </fmt:bundle>
        </main>

    </body>
</html>
