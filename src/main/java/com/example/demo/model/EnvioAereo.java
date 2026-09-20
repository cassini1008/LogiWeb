package com.example.demo.model;

import java.time.LocalDate;

public class EnvioAereo extends Envio {

    private String codigoVuelo;
    private final double tarifaCombustible;
    private final double seguroAduana;

    public EnvioAereo(String codigo, String origen, String destino,
                      double pesoKg, LocalDate fechaSalida,
                      String codigoVuelo) {
        super(codigo, origen, destino, pesoKg, fechaSalida);
        this.codigoVuelo = codigoVuelo;
        this.tarifaCombustible = 12.50;
        this.seguroAduana = 45.00;
    }

    @Override
    public double calcularCosto() {
        double costo = (getPesoKg() * 4.5) + tarifaCombustible + seguroAduana;
        setCostoTotal(costo);
        return costo;
    }

    @Override
    public String obtenerResumen() {
        return super.obtenerResumen() + " | Tipo: Aéreo | Vuelo: " + codigoVuelo;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }
}
