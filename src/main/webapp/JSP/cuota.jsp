<%-- 
    Document   : cuota
    Created on : 10-dic-2021, 10:41:31
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
        <fmt:bundle basename="${idioma}">


            <c:set var="datosContinente" value="${sessionScope.datosContinente}" />
            <c:set var="cuotasContiente" value="${sessionScope.cuotasContiente}" />
            <c:set var="cuotaAcumuladaContinente" value="${sessionScope.cuotaAcumuladaContinente}" />
            <c:set var="datosContenido" value="${sessionScope.datosContenido}" />
            <c:set var="cuotasContenido" value="${sessionScope.cuotasContenido}" />
            <c:set var="cuotaAcumuladaContenido" value="${sessionScope.cuotaAcumuladaContenido}" />

            <header>
                <div class="container__logo">
                    <span class="material-icons">
                        roofing
                    </span>
                    <a href="#"><h1>Roof</h1></a>
                </div>
                <div class="navbar">

                </div>
            </header>
            <main class="main__app">
                <div class="container__presupuesto">
                    <h1 class="titulo__presupuesto"><fmt:message key ="presupuesto" /></h1>
                    <table>
                        <c:if test="${datosContinente!=null}">
                            <caption><fmt:message key ="continente" /></caption>
                            <tr>
                                <th><fmt:message key ="objeto" /></th>
                                <th><fmt:message key ="descripcion" /></th>
                                <th><fmt:message key ="cuota" /></th>
                            </tr>
                            <tr>
                                <td>
                                    <fmt:message key ="tEdificio" />
                                </td>
                                <td style="text-align: right;">
                                    <c:set var="tipoEdificio" value="${datosContinente.tEdificio}" />
                                    <fmt:message key ="tEdificio__options" var="tEdificio__options"/>
                                    <c:set var="tEdificio__options" value="${fn:split(tEdificio__options, ',')}" />
                                    <c:choose>
                                        <c:when test = "${tipoEdificio == 0.95}">
                                            ${tEdificio__options[0]}
                                        </c:when> 
                                        <c:when test = "${tipoEdificio == 1.00}">
                                            ${tEdificio__options[1]}
                                        </c:when> 
                                        <c:when test = "${tipoEdificio == 1.05}">
                                            ${tEdificio__options[2]}
                                        </c:when> 
                                        <c:when test = "${tipoEdificio == 1.10}">
                                            ${tEdificio__options[3]}
                                        </c:when> 
                                        <c:when test = "${tipoEdificio == 1.20}">
                                            ${tEdificio__options[4]}
                                        </c:when> 
                                    </c:choose>
                                </td>  
                                <td style="text-align: right;">
                                    <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" type="currency" value="${cuotasContiente.prTipoEdificio}" />
                                </td>  
                            </tr>
                            <tr>
                                <td>
                                    <fmt:message key ="nHabitaciones" />
                                </td>
                                <td style="text-align: right;">
                                    <fmt:formatNumber value="${datosContinente.nHabitaciones}" />
                                </td>
                                <td style="text-align: right;">
                                    <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" type="currency" value="${cuotasContiente.prHabitaciones}" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <fmt:message key ="tConstruccion__options" var="tConstruccion__options"/>
                                    <c:set var="tConstruccion__options" value="${fn:split(tConstruccion__options, ',')}" />
                                    <fmt:message key ="tConstruccion"/>
                                </td>
                                <td style="text-align: right;">
                                    <c:set var="tipoConstruccion" value="${datosContinente.tConstruccion}" />
                                    <c:choose>
                                        <c:when test = "${tipoConstruccion == 1}">
                                            ${tConstruccion__options[0]}
                                        </c:when> 
                                        <c:when test = "${tipoConstruccion == 2}">
                                            ${tConstruccion__options[1]}
                                        </c:when> 
                                    </c:choose>
                                </td>
                                <td style="text-align: right;">
                                    <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" type="currency" value="${cuotasContiente.prTipoConstr}" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <fmt:message key ="valorMercado"/>
                                </td>
                                <td style="text-align: right;">
                                    <c:set var="valorMercado" value="${datosContinente.valorMercado}" />
                                    <c:choose>
                                        <c:when test = "${valorMercado == 25000}">
                                            <fmt:message key ="menos"/>
                                            <fmt:formatNumber type="currency" value="50000"/>
                                        </c:when> 
                                        <c:when test = "${valorMercado == 50001}">
                                            <fmt:message key ="entre"/>
                                            <fmt:formatNumber type="currency" value="50001"/>
                                            <fmt:message key ="y"/>
                                            <fmt:formatNumber type="currency" value="80000"/>
                                        </c:when> 
                                        <c:when test = "${valorMercado == 80001}">
                                            <fmt:message key ="entre"/>
                                            <fmt:formatNumber type="currency" value="80001"/>
                                            <fmt:message key ="y"/>
                                            <fmt:formatNumber type="currency" value="100000"/>
                                        </c:when> 
                                        <c:when test = "${valorMercado == 100001}">
                                            <fmt:message key ="entre"/>
                                            <fmt:formatNumber type="currency" value="100001"/>
                                            <fmt:message key ="y"/>
                                            <fmt:formatNumber type="currency" value="150000"/>
                                        </c:when> 
                                        <c:when test = "${valorMercado == 125000}">
                                            <fmt:message key ="mas"/>
                                            <fmt:formatNumber type="currency" value="150000"/>
                                        </c:when> 
                                    </c:choose>
                                </td>
                                <td style="text-align: right;">
                                    <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" type="currency" value="${cuotasContiente.cuotaBase}" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <fmt:message key ="fConstruccion"/>
                                </td>
                                <td style="text-align: right;">
                                    <c:set var="fechaConstruccion" value="${datosContinente.fConstruccion}" />
                                    <fmt:message key ="fConstruccion__options" var="fConstruccion__options"/>
                                    <c:set var="fConstruccion__options" value="${fn:split(fConstruccion__options, ',')}" />
                                    <c:choose>
                                        <c:when test = "${fechaConstruccion == 0.09}">
                                            ${fConstruccion__options[0]}
                                        </c:when> 
                                        <c:when test = "${fechaConstruccion == 0.06}">
                                            ${fConstruccion__options[1]}
                                        </c:when> 
                                        <c:when test = "${fechaConstruccion == 0.04}">
                                            ${fConstruccion__options[2]}
                                        </c:when> 
                                        <c:when test = "${fechaConstruccion == 0.02}">
                                            ${fConstruccion__options[3]}
                                        </c:when> 
                                        <c:when test = "${fechaConstruccion == 0.01}">
                                            ${fConstruccion__options[4]}
                                        </c:when> 
                                    </c:choose>
                                </td>
                                <td style="text-align: right;">
                                    <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" type="currency" value="${cuotasContiente.prFechaConstr}" />
                                </td>
                            </tr>
                            <tr class="tr__resultado" style="text-align: right;">
                                <td colspan="2" >
                                    <fmt:message key ="cuotaTotalContinente" />
                                </td>
                                <td>
                                    <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" type="currency" value="${cuotaAcumuladaContinente}" />
                                </td>
                            </tr>
                            <p></p>
                        </c:if>
                    </table>
                    <table>
                        <c:if test="${datosContenido!=null}">
                            <caption><fmt:message key ="contenido" /></caption>
                            <tr>
                                <th><fmt:message key ="objeto" /></th>
                                <th><fmt:message key ="descripcion" /></th>
                                <th><fmt:message key ="cuota" /></th>
                            </tr>
                            <tr>
                                <td>
                                    <fmt:message key ="capitalAsegurado" />
                                </td>
                                <td style="text-align: right;">
                                    <c:set var="capitalAsegurado" value="${datosContenido.capitalAsegurado}" />
                                    <c:choose>
                                        <c:when test = "${capitalAsegurado == 10000}">
                                            <fmt:formatNumber type="currency" value="10000"/>
                                        </c:when> 
                                        <c:when test = "${capitalAsegurado == 20000}">
                                            <fmt:formatNumber type="currency" value="20000"/>
                                        </c:when> 
                                        <c:when test = "${capitalAsegurado == 30000}">
                                            <fmt:formatNumber type="currency" value="30000"/>
                                        </c:when> 
                                        <c:when test = "${capitalAsegurado == 50000}">
                                            <fmt:formatNumber type="currency" value="50000"/>
                                        </c:when> 
                                        <c:when test = "${capitalAsegurado == 100000}">
                                            <fmt:formatNumber type="currency" value="100000"/>
                                        </c:when> 
                                    </c:choose>
                                </td>
                                <td style="text-align: right;">
                                    <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" type="currency" value="${cuotasContenido.primaCantidadAsegurada}" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <fmt:message key ="franquicia" />
                                </td>
                                <td style="text-align: right;">
                                    <c:set var="franquicia" value="${datosContenido.franquicia}" />
                                    <c:choose>
                                        <c:when test = "${franquicia == 0}">
                                            <fmt:message key ="franquicia__options" />
                                        </c:when> 
                                        <c:when test = "${franquicia == 0.1}">
                                            <fmt:formatNumber type="currency" value="500"/>
                                        </c:when> 
                                        <c:when test = "${franquicia == 0.2}">
                                            <fmt:formatNumber type="currency" value="1000"/>
                                        </c:when> 
                                    </c:choose>
                                </td>
                                <td style="text-align: right;">
                                    <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" type="currency" value="${cuotasContenido.primaFranquicia}" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <fmt:message key ="seguroAccidente" />
                                </td>
                                <td style="text-align: right;">
                                    <c:set var="seguroAccidente" value="${datosContenido.seguroAccidente}" />
                                    <c:choose>
                                        <c:when test = "${seguroAccidente == true}">
                                            <fmt:message key ="si" />
                                        </c:when> 
                                        <c:when test = "${seguroAccidente == false}">
                                            <fmt:message key ="no" />
                                        </c:when> 
                                    </c:choose>
                                </td>
                                <td style="text-align: right;">
                                    <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" type="currency" value="${cuotasContenido.primaSeguroAccidente}" />
                                </td>
                            </tr>
                            <tr class="tr__resultado" style="text-align: right;">
                                <td colspan="2"><fmt:message key ="cuotaTotalContenido" /></td>
                                <td ><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" type="currency" value="${cuotaAcumuladaContenido}" /></td>
                            </tr>
                        </c:if>
                    </table>
                    <table class="resultadoTotal">
                        <tr class="tr__resultado final" style="width: 100%; text-align: right;">
                            <td style="border: none;">
                                <u><fmt:message key ="total" />:
                                <c:choose>
                                    <c:when test = "${cuotaAcumuladaContinente!=null && cuotaAcumuladaContenido!=null}">
                                        <fmt:formatNumber type="currency" value="${cuotaAcumuladaContinente + cuotaAcumuladaContenido}"/></u>
                                        </c:when> 
                                        <c:when test = "${cuotaAcumuladaContinente!=null && cuotaAcumuladaContenido == null}">
                                        <fmt:formatNumber type="currency" value="${cuotaAcumuladaContinente}"/></u>
                                        </c:when> 
                                        <c:when test = "${cuotaAcumuladaContinente==null && cuotaAcumuladaContenido != null}">
                                        <fmt:formatNumber type="currency" value="${cuotaAcumuladaContenido}"/></u>
                                        </c:when>
                                    </c:choose>
                            </td>
                        </tr>
                    </table>
                    <form action="Inicio" method="POST" class="form__cuota">
                        <button name="btnCuota" value="actualizar" class="btn__cuota"><fmt:message key ="actualizar" /></button>
                        <a href="https://google.com" class="btn__cuota"><fmt:message key ="terminar" /></a>
                    </form>
                </div>
            </main>
        </fmt:bundle>

    </body>
</html>
