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
public class ContenidoBean implements Serializable{
    
    private double capitalAsegurado;
    private double franquicia;
    private boolean seguroAccidente;

    public double getCapitalAsegurado() {
        return capitalAsegurado;
    }

    public void setCapitalAsegurado(double capitalAsegurado) {
        this.capitalAsegurado = capitalAsegurado;
    }

    public boolean getSeguroAccidente() {
        return seguroAccidente;
    }

    public void setSeguroAccidente(boolean seguroAccidente) {
        this.seguroAccidente = seguroAccidente;
    }

    public double getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(double franquicia) {
        this.franquicia = franquicia;
    }
    
}
