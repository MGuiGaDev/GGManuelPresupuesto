/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;

/**
 *
 * @author Manuel Guillén Gallardo
 */


public class EleccionBean implements Serializable{
    
    /**
     * CONTENIDO Y CONTINENTE ACTÚNA COMO VARIABLES DE TIPO BOOLEANO, PERO PARA DIFERENCIARLOS
     * ESTABLECEREMOS LA SIGUIENTE NORMA:
     * - SI CONTINENTE HA SIDO ELEGIDO = 1
     * - SI CONTENIDO HA SIDO ELEGIDO = 2
     * - AMBOS, CUANDO NO SON ELEGIDOS SON = 0
     */
    private byte contenido;
    private byte continente;

    public byte getContenido() {
        return contenido;
    }

    public void setContenido(byte contenido) {
        this.contenido = contenido;
    }

    public byte getContinente() {
        return continente;
    }

    public void setContinente(byte continente) {
        this.continente = continente;
    }

    
}
