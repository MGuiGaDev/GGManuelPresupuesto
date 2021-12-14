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
public class ContinenteBean implements Serializable{
    
    //private double cuotaBase;
    private double tEdificio;
    private double nHabitaciones;
    private byte tConstruccion;
    private double valorMercado;
    private double fConstruccion;

    /*
    public double getCuotaBase() {
        return cuotaBase;
    }

    public void setCuotaBase(double cuotaBase) {
        this.cuotaBase = cuotaBase;
    }*/

    public double gettEdificio() {
        return tEdificio;
    }

    public void settEdificio(double tEdificio) {
        this.tEdificio = tEdificio;
    }

    public double getnHabitaciones() {
        return nHabitaciones;
    }

    public void setnHabitaciones(double nHabitaciones) {
        this.nHabitaciones = nHabitaciones;
    }

    public double getfConstruccion() {
        return fConstruccion;
    }

    public void setfConstruccion(double fConstruccion) {
        this.fConstruccion = fConstruccion;
    }

    public byte gettConstruccion() {
        return tConstruccion;
    }

    public void settConstruccion(byte tConstruccion) {
        this.tConstruccion = tConstruccion;
    }

    public double getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(double valorMercado) {
        this.valorMercado = valorMercado;
    }

    
}
