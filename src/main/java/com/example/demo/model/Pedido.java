package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Long id;
    private Cliente cliente;
    private List<Envio> envios;
    private List<Paquete> paquetes;  

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.envios = new ArrayList<>();
        this.paquetes = new ArrayList<>();
    }

    public void agregarEnvio(Envio envio) {
        envios.add(envio);
    }

    public void agregarPaquete(String descripcion, double pesoKg) {
        this.paquetes.add(new Paquete(descripcion, pesoKg)); 
    }

    public double calcularCostoTotal() {
        return envios.stream()
                .mapToDouble(Envio::calcularCosto)
                .sum();
    }

    public List<Envio> getEnvios() {
        return envios;
    }
    public List<Paquete> getPaquetes() {
        return paquetes;
    }
    public Cliente getCliente() { 
        return cliente; 
    }
    public Long getId() { 
        return id; 
    }
}
