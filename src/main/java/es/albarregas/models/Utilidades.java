/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.models;

import es.albarregas.beans.ContenidoBean;
import es.albarregas.beans.ContinenteBean;
import es.albarregas.beans.EleccionBean;
import java.io.Serializable;
import javax.servlet.http.Cookie;

/**
 *
 * @author Manuel Guillén Gallardo
 */
public class Utilidades implements Serializable{

    /**
     * 
     * @param coleccionCookie
     * @return 
     */
    public static Cookie encontrarCookie(Cookie[] coleccionCookie) {
        Cookie nuevaCookie = null;
        if (coleccionCookie != null) {
            for (Cookie c : coleccionCookie) {
                if (c.getName().equals("cookieCuota")) {
                    nuevaCookie = c;
                }
            }
        }
        return nuevaCookie;
    }

    /**
     * 
     * @param contenidoBean
     * @param eleccionBean
     * @param idiomaElegido
     * @return 
     */
    public static Cookie crearCookieCuotaContenido(ContenidoBean contenidoBean, EleccionBean eleccionBean, String idiomaElegido) {
        StringBuilder datosCuota = new StringBuilder();
        datosCuota.append(eleccionBean.getContenido())
                .append("#")
                .append(contenidoBean.getCapitalAsegurado())
                .append("-").append(contenidoBean.getFranquicia())
                .append("-").append(contenidoBean.getSeguroAccidente())
                .append("#")
                .append(idiomaElegido);
        Cookie cookieCuota = new Cookie("cookieCuota", datosCuota.toString());
        return cookieCuota;

    }

    /**
     * 
     * @param continenteBean
     * @param eleccionBean
     * @param idiomaElegido
     * @return 
     */
    public static Cookie crearCookieCuotaContinente(ContinenteBean continenteBean, EleccionBean eleccionBean, String idiomaElegido) {
        StringBuilder datosContinente = new StringBuilder();
        datosContinente.append(eleccionBean.getContinente()).append("#")
                .append(continenteBean.gettEdificio())
                .append("-").append(continenteBean.getnHabitaciones())
                .append("-").append(continenteBean.gettConstruccion())
                .append("-").append(continenteBean.getValorMercado())
                .append("-").append(continenteBean.getfConstruccion())
                .append("#")
                .append(idiomaElegido);
        Cookie cookieCuota = new Cookie("cookieCuota", datosContinente.toString());
        return cookieCuota;
    }

    /**
     * 
     * @param continenteBean
     * @param contenidoBean
     * @param eleccionBean
     * @param idiomaElegido
     * @return 
     */
    public static Cookie crearCookieCuotaCompleta(ContinenteBean continenteBean, ContenidoBean contenidoBean, EleccionBean eleccionBean, String idiomaElegido) {
        StringBuilder datosCuota = new StringBuilder();
        datosCuota.append(eleccionBean.getContinente()).append(eleccionBean.getContenido())
                .append("#")
                .append(continenteBean.gettEdificio())
                .append("-").append(continenteBean.getnHabitaciones())
                .append("-").append(continenteBean.gettConstruccion())
                .append("-").append(continenteBean.getValorMercado())
                .append("-").append(continenteBean.getfConstruccion())
                .append("#")
                .append(contenidoBean.getCapitalAsegurado())
                .append("-").append(contenidoBean.getFranquicia())
                .append("-").append(contenidoBean.getSeguroAccidente())
                .append("#")
                .append(idiomaElegido);
        Cookie cookieCuota = new Cookie("cookieCuota", datosCuota.toString());
        return cookieCuota;
    }

    /**
     * 
     * @param datosCookie
     * @return 
     */
    public static ContenidoBean cargarContenidoConCookie(String[] datosCookie) {
        ContenidoBean cookieContenido = new ContenidoBean();
        cookieContenido.setCapitalAsegurado(Double.parseDouble(datosCookie[0]));
        cookieContenido.setFranquicia(Double.parseDouble(datosCookie[1]));
        boolean cubrirAccidente = datosCookie[2].equals("true");
        cookieContenido.setSeguroAccidente(cubrirAccidente);
        return cookieContenido;
    }

    /**
     * 
     * @param datosCookie
     * @return 
     */
    public static ContinenteBean cargarContinenteConCookie(String[] datosCookie) {
        ContinenteBean cookieContinente = new ContinenteBean();
        cookieContinente.settEdificio(Double.parseDouble(datosCookie[0]));
        cookieContinente.setnHabitaciones(Double.parseDouble(datosCookie[1]));
        cookieContinente.settConstruccion(Byte.parseByte(datosCookie[2]));
        cookieContinente.setValorMercado(Double.parseDouble(datosCookie[3]));
        cookieContinente.setfConstruccion(Double.parseDouble(datosCookie[4]));
        return cookieContinente;
    }
}
