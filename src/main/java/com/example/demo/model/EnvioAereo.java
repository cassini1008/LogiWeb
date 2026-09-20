package com.example.demo.model;

import java.time.LocalDate;

public class EnvioAereo extends Envio {

    private String codigoVuelo;
    private static final double TARIFA_COMBUSTIBLE = 12.50;
    private Aduana aduana;        

    public EnvioAereo(String codigo, String origen, String destino,
                      double pesoKg, LocalDate fechaSalida,
                      String codigoVuelo, Aduana aduana) {
        super(codigo, origen, destino, pesoKg, fechaSalida);
        this.codigoVuelo = codigoVuelo;
        this.aduana = aduana;
    }

    @Override
    public double calcularCosto() {
        double costo = (getPesoKg() * 4.5) + TARIFA_COMBUSTIBLE + aduana.getImpuesto();
        setCostoTotal(costo);
        return costo;
    }

    @Override
    public String obtenerResumen() {
        return super.obtenerResumen() + " | Tipo: Aéreo | Vuelo: " + codigoVuelo
                                      + " | Aduana: " + aduana.getPais();
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public Aduana getAduana() {
        return aduana;
    }
}
