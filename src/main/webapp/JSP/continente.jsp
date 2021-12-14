<%-- 
    Document   : continente
    Created on : 10-dic-2021, 10:40:55
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


        <fmt:bundle basename="${idioma}">
            <main class="main__eleccion">
                <form action="${pageContext.request.contextPath}/Continente" method="POST" class="form__eleccion">
                    <c:set var="continenteCookie" value="${sessionScope.continenteCookie}" />
                    <div class="form__header">
                        <h2 id="continente__legend"><fmt:message key ="continente__legend" /></h2>
                        <p id="continente__text"><strong><fmt:message key ="continente__text" /></strong></p>
                    </div>
                    <div class="container__input">
                        <fmt:message key ="tEdificio__options" var="tEdificio__options"/>
                        <c:set var="tEdificio__options" value="${fn:split(tEdificio__options, ',')}" />
                        <label for="tEdificio"><fmt:message key ="tEdificio" />: </label>
                        <select name="tEdificio" id="tEdificio">
                            <option value="0.95" ${continenteCookie.tEdificio==0.95 || continenteCookie == null? 'selected="selected"':''}>${tEdificio__options[0]}</option>
                            <option value="1.00" ${continenteCookie.tEdificio==1.00? 'selected="selected"':''}>${tEdificio__options[1]}</option>
                            <option value="1.05" ${continenteCookie.tEdificio==1.05? 'selected="selected"':''}>${tEdificio__options[2]}</option>
                            <option value="1.10" ${continenteCookie.tEdificio==1.10? 'selected="selected"':''}>${tEdificio__options[3]}</option>
                            <option value="1.20" ${continenteCookie.tEdificio==1.20? 'selected="selected"':''}>${tEdificio__options[4]}</option>
                        </select> 
                    </div>

                    <div class="container__input">
                        <label for="nHabitaciones"><fmt:message key ="nHabitaciones" />:</label>
                        <select name="nHabitaciones" id="nHabitaciones">
                            <option value="1" ${continenteCookie.nHabitaciones==1 || continenteCookie == null? 'selected="selected"':''}>1</option>
                            <option value="2" ${continenteCookie.nHabitaciones==2? 'selected="selected"':''}>2</option>
                            <option value="3" ${continenteCookie.nHabitaciones==3? 'selected="selected"':''}>3</option>
                            <option value="4" ${continenteCookie.nHabitaciones==4? 'selected="selected"':''}>4</option>
                            <option value="5" ${continenteCookie.nHabitaciones==5? 'selected="selected"':''}>5</option>
                            <!-- PROBLEMA = CUANDO SELECCIONO MÁS DE CINCO, AL RECUPERAR EL DATO, EL PROGRAMA QUÉ SELECCIONARÁ: 5 o + de 5 -->
                            <option value="5" ${continenteCookie.nHabitaciones==5? 'selected="selected"':''}><fmt:message key ="nHabitaciones__options" /></option>
                        </select>
                    </div>
                    <div class="container__input">
                        <fmt:message key ="tConstruccion__options" var="tConstruccion__options"/>
                        <c:set var="tConstruccion__options" value="${fn:split(tConstruccion__options, ',')}" />
                        <label><fmt:message key ="tConstruccion"/>:</label>
                        <input type="radio" name="tConstruccion" id="tConstruccionMadera" value="1" ${continenteCookie.tConstruccion == 1 || continenteCookie == null? 'checked':''}/>
                        <label for="tConstruccionMadera">${tConstruccion__options[0]}</label>
                        <input type="radio" name="tConstruccion" id="tConstruccionHormigon" value="2" ${continenteCookie.tConstruccion == 2? 'checked':''}/>
                        <label for="tConstruccionHormigon">${tConstruccion__options[1]}</label> 
                    </div>

                    <div class="container__input">
                        <label for="valorMercado"><fmt:message key ="valorMercado"/>:</label>
                        <select name="valorMercado" id="valorMercado">
                            <option value="25000" ${continenteCookie.tConstruccion==25000 || continenteCookie == null? 'selected="selected"':''}>
                                <fmt:message key ="menos"/>
                                <fmt:formatNumber type="currency" value="50.000"/>
                            </option>
                            <option value="50001" ${continenteCookie.tConstruccion==50001? 'selected="selected"':''}>
                                <fmt:message key ="entre"/>
                                <fmt:formatNumber type="currency" value="50.001"/>
                                <fmt:message key ="y"/>
                                <fmt:formatNumber type="currency" value="80.000"/>
                            </option>
                            <option value="80001" ${continenteCookie.tConstruccion==80001? 'selected="selected"':''}>
                                <fmt:message key ="entre"/>
                                <fmt:formatNumber type="currency" value="80.001"/>
                                <fmt:message key ="y"/>
                                <fmt:formatNumber type="currency" value="100.000"/>
                            </option>
                            <option value="100001" ${continenteCookie.tConstruccion==100001? 'selected="selected"':''}>
                                <fmt:message key ="entre"/>
                                <fmt:formatNumber type="currency" value="100.001"/>
                                <fmt:message key ="y"/>
                                <fmt:formatNumber type="currency" value="150.000"/>
                            </option>
                            <option value="125000" ${continenteCookie.tConstruccion==125000? 'selected="selected"':''}>
                                <fmt:message key ="mas"/>
                                <fmt:formatNumber type="currency" value="150.000"/>
                            </option>
                        </select>
                    </div>
                    <div class="container__input">
                        <fmt:message key ="fConstruccion__options" var="fConstruccion__options"/>
                        <c:set var="fConstruccion__options" value="${fn:split(fConstruccion__options, ',')}" />
                        <label for="fConstruccion"><fmt:message key ="fConstruccion"/>:</label>
                        <select name="fConstruccion" id="fConstruccion">
                            <option value="0.09" ${continenteCookie.fConstruccion==0.09 || continenteCookie == null? 'selected="selected"':''}>${fConstruccion__options[0]}</option>
                            <option value="0.06" ${continenteCookie.fConstruccion==0.06? 'selected="selected"':''}>${fConstruccion__options[1]}</option>
                            <option value="0.04" ${continenteCookie.fConstruccion==0.04? 'selected="selected"':''}>${fConstruccion__options[2]}</option>
                            <option value="0.02" ${continenteCookie.fConstruccion==0.02? 'selected="selected"':''}>${fConstruccion__options[3]}</option>
                            <option value="0.01" ${continenteCookie.fConstruccion==0.01? 'selected="selected"':''}>${fConstruccion__options[4]}</option>
                        </select>
                    </div>

                    <button type="submit" name="continuar" value="continuar" class="btn"><fmt:message key ="btn__continuar"/></button>
                </form>
            </main>
        </fmt:bundle>
    </body>
</html>
