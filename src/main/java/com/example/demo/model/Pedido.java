package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Long id;
    private Cliente cliente;
    private List<Envio> envios;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.envios = new ArrayList<>();
    }

    public void agregarEnvio(Envio envio) {
        envios.add(envio);
    }

    public double calcularCostoTotal() {
        return envios.stream()
                .mapToDouble(Envio::calcularCosto)
                .sum();
    }

    public List<Envio> getEnvios() {
        return envios;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Long getId() {
        return id;
    }
}
