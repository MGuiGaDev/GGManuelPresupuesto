/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.ContenidoBean;
import es.albarregas.beans.ContinenteBean;
import es.albarregas.beans.EleccionBean;
import es.albarregas.models.Utilidades;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manuel Guillén Gallardo
 */
@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

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
        request.getSession().invalidate();
        Cookie[] cookies = request.getCookies();
        Cookie cookieCuota = Utilidades.encontrarCookie(cookies);
        if (cookieCuota != null) {
            ContenidoBean contenidoCookie = null;
            ContinenteBean continenteCookie = null;
            String[] datosCookie = cookieCuota.getValue().split("#");
            int indice = datosCookie.length - 1;
            String idiomaElegido = datosCookie[indice];
            request.getSession().setAttribute("idiomaElegido", idiomaElegido);
            EleccionBean eleccionBean = new EleccionBean();
            switch (datosCookie[0]) {
                case "12":
                    continenteCookie = Utilidades.cargarContinenteConCookie(datosCookie[1].split("-"));
                    contenidoCookie = Utilidades.cargarContenidoConCookie(datosCookie[2].split("-"));
                    request.getSession().setAttribute("continenteCookie", continenteCookie);
                    request.getSession().setAttribute("contenidoCookie", contenidoCookie);
                    eleccionBean.setContinente(Byte.parseByte("1"));
                    eleccionBean.setContenido(Byte.parseByte("2"));
                    request.getSession().setAttribute("eleccionBean", eleccionBean);
                    break;
                case "1":
                    continenteCookie = Utilidades.cargarContinenteConCookie(datosCookie[1].split("-"));
                    request.getSession().setAttribute("continenteCookie", continenteCookie);
                    eleccionBean.setContinente(Byte.parseByte("1"));
                    request.getSession().setAttribute("eleccionBean", eleccionBean);
                    break;
                case "2":
                    contenidoCookie = Utilidades.cargarContenidoConCookie(datosCookie[1].split("-"));
                    request.getSession().setAttribute("contenidoCookie", contenidoCookie);
                    eleccionBean.setContenido(Byte.parseByte("2"));
                    request.getSession().setAttribute("eleccionBean", eleccionBean);
                    break;
            }
            url = "JSP/eleccion.jsp";
        } else {
            url = "index.jsp";
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
