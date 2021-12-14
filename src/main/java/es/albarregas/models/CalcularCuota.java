/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.models;

import java.io.Serializable;

/**
 *
 * @author Manuel Guillén Gallardo
 */
public class CalcularCuota implements Serializable {

    /**
     *
     * @param valorMercado
     * @return
     */
    public static double calcularCuotaBase(double valorMercado) {
        double cuotaBase = valorMercado * 0.005;
        return cuotaBase;
    }

    /**
     *
     * @param tipoEdificio
     * @param cuotaBase
     * @return
     */
    public static double calcularPrimaTipoEdificio(double tipoEdificio, double cuotaBase) {
        double primaTipoEdificio = tipoEdificio * cuotaBase;
        return primaTipoEdificio;
    }

    /**
     *
     * @param numeroHabitaciones
     * @param acumulado
     * @return
     */
    public static double calcularPrimaHabitaciones(double numeroHabitaciones, double acumulado) {
        double primaHabitaciones = numeroHabitaciones * (acumulado / 100);
        return primaHabitaciones;
    }

    /**
     *
     * @param annioContruccion
     * @param acumulado
     * @return
     */
    public static double calcularPrimaAnnioConstruccion(double cuotaAnnioContruccion, double acumulado) {
        double primaAnnioConstruccion = cuotaAnnioContruccion * acumulado;
        return primaAnnioConstruccion;
    }

    /**
     *
     * @param tipoConstruccion
     * @param acumulado
     * @return
     */
    public static double calcularPrimaTipoConstruccion(byte tipoConstruccion, double acumulado) {
        double primaTipoConstruccion = tipoConstruccion == 1 ? acumulado * 0.1 : 0;
        return primaTipoConstruccion;
    }

    public static double calcularPrimaCantidadAsegurada(double cantidadAsegurada) {
        double primaCantidadAsegurada = cantidadAsegurada * 0.008;
        return primaCantidadAsegurada;
    }

    public static double calcularPrimaSeguroAccidentes(boolean seguro, double acumulado) {
        double primaAccidente = seguro ? acumulado * 1.25 : 0;
        return primaAccidente;
    }

    public static double calcularPrimaFranquicia(double franquicia, double acumulado) {
        double primaFranquicia = acumulado * franquicia;
        return primaFranquicia;
    }
}
