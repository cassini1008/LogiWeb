package com.example.demo.model;

public class Domicilio {

    private Long id;
    private String calle;
    private String ciudad;
    private String codigoPostal;

    public Domicilio(String calle, String ciudad, String codigoPostal) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }
}
