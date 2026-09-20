package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Envio;
import com.example.demo.model.Pedido;
import com.example.demo.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioService {

    private final PedidoRepository pedidoRepository;

    public EnvioService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido getPedidoActual() {
        return pedidoRepository.getPedido();
    }

    public void registrarCliente(Cliente cliente) {
        pedidoRepository.setPedido(new Pedido(cliente));
    }

    public void agregarEnvio(Envio envio) {
        pedidoRepository.getPedido().agregarEnvio(envio);
    }

    public double calcularTotalPedido(Pedido pedido) {
        return pedido.calcularCostoTotal();
    }

    public void notificarEnvios(List<Envio> envios, String mensaje) {
        for (Envio envio : envios) {
            envio.enviarNotificacion(mensaje);
        }
    }
}