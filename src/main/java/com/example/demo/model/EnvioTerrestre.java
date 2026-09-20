package com.example.demo.model;

import java.time.LocalDate;

public class EnvioTerrestre extends Envio {

    private Vehiculo vehiculo;    
    private double distanciaKm;
    private static final double TARIFA_BASE = 2.50;

    public EnvioTerrestre(String codigo, String origen, String destino,
                          double pesoKg, LocalDate fechaSalida,
                          Vehiculo vehiculo, double distanciaKm) {
        super(codigo, origen, destino, pesoKg, fechaSalida);
        this.vehiculo = vehiculo;
        this.distanciaKm = distanciaKm;
    }

    @Override
    public double calcularCosto() {
        double costo = (getPesoKg() * 1.8) + (distanciaKm * TARIFA_BASE);
        setCostoTotal(costo);
        return costo;
    }

    @Override
    public String obtenerResumen() {
        return super.obtenerResumen() + " | Tipo: Terrestre | Placa: " + vehiculo.getPlaca();
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }
}
