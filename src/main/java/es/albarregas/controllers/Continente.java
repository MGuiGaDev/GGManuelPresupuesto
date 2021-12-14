/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.ContinenteBean;
import es.albarregas.beans.EleccionBean;
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
@WebServlet(name = "Continente", urlPatterns = {"/Continente"})
public class Continente extends HttpServlet {

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
        ContinenteBean datosContinente = new ContinenteBean();

        try {

            BeanUtils.populate(datosContinente, request.getParameterMap());
            PrimasContinenteBean cuotasContiente = new PrimasContinenteBean();

            cuotasContiente.setCuotaBase(CalcularCuota.calcularCuotaBase(datosContinente.getValorMercado()));
            cuotasContiente.setPrTipoEdificio(CalcularCuota.calcularPrimaTipoEdificio(datosContinente.gettEdificio(), cuotasContiente.getCuotaBase()));
            double cuotaAcumuladaContinente = cuotasContiente.getPrTipoEdificio();

            cuotasContiente.setPrHabitaciones(CalcularCuota.calcularPrimaHabitaciones(datosContinente.getnHabitaciones(), cuotaAcumuladaContinente));
            cuotaAcumuladaContinente += cuotasContiente.getPrHabitaciones();

            cuotasContiente.setPrFechaConstr(CalcularCuota.calcularPrimaAnnioConstruccion(datosContinente.getfConstruccion(), cuotaAcumuladaContinente));
            cuotaAcumuladaContinente += cuotasContiente.getPrFechaConstr();

            cuotasContiente.setPrTipoConstr(CalcularCuota.calcularPrimaTipoConstruccion(datosContinente.gettConstruccion(), cuotaAcumuladaContinente));
            cuotaAcumuladaContinente += cuotasContiente.getPrTipoConstr();

            request.getSession().setAttribute("datosContinente", datosContinente);
            request.getSession().setAttribute("cuotasContiente", cuotasContiente);
            request.getSession().setAttribute("cuotaAcumuladaContinente", cuotaAcumuladaContinente);
            EleccionBean eleccionBean = new EleccionBean();

            eleccionBean = (EleccionBean) request.getSession().getAttribute("eleccionBean");
            if (eleccionBean != null) {
                if (eleccionBean.getContenido() == 2) {
                    url = "JSP/contenido.jsp";
                } else {
                    String idiomaElegido = (String) request.getSession().getAttribute("idiomaElegido");
                    Cookie cookieCuota = Utilidades.crearCookieCuotaContinente(datosContinente, eleccionBean, idiomaElegido);
                    cookieCuota.setMaxAge(60 * 60 * 24 * 2);
                    response.addCookie(cookieCuota);
                    url = "JSP/cuota.jsp";
                }
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
