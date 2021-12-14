/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.ContenidoBean;
import es.albarregas.beans.ContinenteBean;
import es.albarregas.beans.EleccionBean;
import es.albarregas.beans.PrimasContenidoBean;
import es.albarregas.beans.PrimasContinenteBean;
import es.albarregas.models.CalcularCuota;
import es.albarregas.models.Utilidades;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Manuel Guillén Gallardo
 */
@WebServlet(name = "Contenido", urlPatterns = {"/Contenido"})
public class Contenido extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "";
        ContenidoBean datosContenido = new ContenidoBean();
        try {

            BeanUtils.populate(datosContenido, request.getParameterMap());
            PrimasContenidoBean cuotasContenido = new PrimasContenidoBean();

            cuotasContenido.setPrimaCantidadAsegurada(CalcularCuota.calcularPrimaCantidadAsegurada(datosContenido.getCapitalAsegurado()));
            double cuotaAcumuladaContenido = cuotasContenido.getPrimaCantidadAsegurada();

            cuotasContenido.setPrimaSeguroAccidente(CalcularCuota.calcularPrimaSeguroAccidentes(datosContenido.getSeguroAccidente(), cuotaAcumuladaContenido));
            cuotaAcumuladaContenido += cuotasContenido.getPrimaSeguroAccidente();

            cuotasContenido.setPrimaFranquicia(CalcularCuota.calcularPrimaFranquicia(datosContenido.getFranquicia(), cuotaAcumuladaContenido));
            cuotaAcumuladaContenido -= cuotasContenido.getPrimaFranquicia();

            request.getSession().setAttribute("datosContenido", datosContenido);
            request.getSession().setAttribute("cuotasContenido", cuotasContenido);
            request.getSession().setAttribute("cuotaAcumuladaContenido", cuotaAcumuladaContenido);

            if (request.getSession().getAttribute("eleccionBean") != null) {
                
                /*
                RECUPERO ESTOS ATRIBUTOS DE SESIÓN PARA PODERLOS GUARDAR EN LAS COOKIES
                AUNQUE PODRÍA INTRODUCIRLOS COMO PARAMETROS DIRECTAMENTE HACIENDO LA LLAMADA EN LA CLAUSULA
                DEL METODO
                */
                EleccionBean elecc = (EleccionBean) request.getSession().getAttribute("eleccionBean");
                String idiomaElegido = (String) request.getSession().getAttribute("idiomaElegido");
                if (elecc.getContinente() != 1) {
                    Cookie cookieCuota = Utilidades.crearCookieCuotaContenido(datosContenido, elecc, idiomaElegido);
                    cookieCuota.setMaxAge(60 * 60 * 24 * 2);
                    response.addCookie(cookieCuota);
                    url = "JSP/cuota.jsp";

                } else {
                    ContinenteBean datosContinente = (ContinenteBean) request.getSession().getAttribute("datosContinente");
                    Cookie cookieCuota = Utilidades.crearCookieCuotaCompleta(datosContinente, datosContenido, elecc, idiomaElegido);
                    cookieCuota.setMaxAge(60 * 60 * 24 * 2);
                    response.addCookie(cookieCuota);
                    url = "JSP/cuota.jsp";
                }

            } else {
                url = "JSP/contenido.jsp";
            }

        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(Continente.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher(url).forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
