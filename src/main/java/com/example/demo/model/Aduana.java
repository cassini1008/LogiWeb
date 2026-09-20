package com.example.demo.model;

public class Aduana {

    private String pais;
    private double impuesto;

    public Aduana(String pais, double impuesto) {
        this.pais = pais;
        this.impuesto = impuesto;
    }

    public String getPais() {
        return pais;
    }

    public double getImpuesto() {
        return impuesto;
    }
}
