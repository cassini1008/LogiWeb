package com.example.demo.model;

public class Vehiculo {

    private String placa;
    private String tipo;
    private double capacidadKg;

    public Vehiculo(String placa, String tipo, double capacidadKg) {
        this.placa = placa;
        this.tipo = tipo;
        this.capacidadKg = capacidadKg;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCapacidadKg() {
        return capacidadKg;
    }
}
