package com.example.demo.model;

public class Paquete {

    private Long id;
    private String descripcion;
    private double pesoKg;

    public Paquete(String descripcion, double pesoKg) {
        this.descripcion = descripcion;
        this.pesoKg = pesoKg;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPesoKg() {
        return pesoKg;
    }
}
