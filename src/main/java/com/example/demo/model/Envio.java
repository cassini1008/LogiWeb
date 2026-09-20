package com.example.demo.model;

import java.time.LocalDate;

public abstract class Envio implements Notificable {

    private Long id;
    private String codigo;
    private String origen;
    private String destino;
    private double pesoKg;
    private LocalDate fechaSalida;
    private String estado;
    private double costoTotal;

    protected Envio(String codigo, String origen, String destino,
                    double pesoKg, LocalDate fechaSalida) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.pesoKg = pesoKg;
        this.fechaSalida = fechaSalida;
        this.estado = "PENDIENTE";
    }

    public abstract double calcularCosto();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Notificación del envío " + codigo + ": " + mensaje);
    }

    public String obtenerResumen() {
        return "Envío " + codigo + " - " + origen + " -> " + destino
                + " | Peso: " + pesoKg + " kg | Estado: " + estado;
    }
}
