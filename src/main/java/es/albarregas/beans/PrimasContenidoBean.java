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
public class PrimasContenidoBean implements Serializable{
    
    private double primaCantidadAsegurada;
    private double primaSeguroAccidente;
    private double primaFranquicia;

    public double getPrimaCantidadAsegurada() {
        return primaCantidadAsegurada;
    }

    public void setPrimaCantidadAsegurada(double primaCantidadAsegurada) {
        this.primaCantidadAsegurada = primaCantidadAsegurada;
    }

    public double getPrimaSeguroAccidente() {
        return primaSeguroAccidente;
    }

    public void setPrimaSeguroAccidente(double primaSeguroAccidente) {
        this.primaSeguroAccidente = primaSeguroAccidente;
    }

    public double getPrimaFranquicia() {
        return primaFranquicia;
    }

    public void setPrimaFranquicia(double primaFranquicia) {
        this.primaFranquicia = primaFranquicia;
    }

    
    
    
    
}
