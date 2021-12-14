/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.EleccionBean;
import es.albarregas.models.Utilidades;
import java.io.IOException;
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
@WebServlet(name = "Eleccion", urlPatterns = {"/Eleccion"})
public class Eleccion extends HttpServlet {

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
        EleccionBean eleccionBean = new EleccionBean();
        if (request.getParameterValues("chkEleccion") == null) {
            url = "JSP/eleccion.jsp";

        } else {
            //REFORMULAR
            String[] colCheckEleccion = request.getParameterValues("chkEleccion");
            StringBuilder datosEleccion = new StringBuilder();
            for (String checkValue : colCheckEleccion) {
                switch (checkValue) {
                    case "chkContinente":
                        eleccionBean.setContinente(Byte.parseByte("1"));
                        datosEleccion.append(eleccionBean.getContinente());
                        break;
                    case "chkContenido":
                        eleccionBean.setContenido(Byte.parseByte("2"));
                        datosEleccion.append(eleccionBean.getContenido());
                        break;
                }
            }
            request.getSession().setAttribute("eleccionBean", eleccionBean);
            if (eleccionBean.getContinente() == 1) {
                url = "JSP/continente.jsp";
            } else {
                url = "JSP/contenido.jsp";
            }
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
