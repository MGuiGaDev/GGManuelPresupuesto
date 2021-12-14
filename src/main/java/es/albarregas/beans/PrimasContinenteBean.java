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
public class PrimasContinenteBean implements Serializable{

    private double cuotaBase;
    private double prTipoEdificio;
    private double prHabitaciones;
    private double prFechaConstr;
    private double prTipoConstr;

    public double getCuotaBase() {
        return cuotaBase;
    }

    public void setCuotaBase(double cuotaBase) {
        this.cuotaBase = cuotaBase;
    }

    public double getPrTipoEdificio() {
        return prTipoEdificio;
    }

    public void setPrTipoEdificio(double prTipoEdificio) {
        this.prTipoEdificio = prTipoEdificio;
    }

    public double getPrHabitaciones() {
        return prHabitaciones;
    }

    public void setPrHabitaciones(double prHabitaciones) {
        this.prHabitaciones = prHabitaciones;
    }

    public double getPrFechaConstr() {
        return prFechaConstr;
    }

    public void setPrFechaConstr(double prFechaConstr) {
        this.prFechaConstr = prFechaConstr;
    }

    public double getPrTipoConstr() {
        return prTipoConstr;
    }

    public void setPrTipoConstr(double prTipoConstr) {
        this.prTipoConstr = prTipoConstr;
    }

    

    
    
}
