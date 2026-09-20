package com.example.demo.model;

import java.time.LocalDate;

public class EnvioTerrestre extends Envio {

    private String placaVehiculo;
    private double distanciaKm;
    private final double tarifaBase;

    public EnvioTerrestre(String codigo, String origen, String destino,
                         double pesoKg, LocalDate fechaSalida,
                         String placaVehiculo, double distanciaKm) {
        super(codigo, origen, destino, pesoKg, fechaSalida);
        this.placaVehiculo = placaVehiculo;
        this.distanciaKm = distanciaKm;
        this.tarifaBase = 2.50;
    }

    @Override
    public double calcularCosto() {
        double costo = (getPesoKg() * 1.8) + (distanciaKm * tarifaBase);
        setCostoTotal(costo);
        return costo;
    }

    @Override
    public String obtenerResumen() {
        return super.obtenerResumen() + " | Tipo: Terrestre | Placa: " + placaVehiculo;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }
}
