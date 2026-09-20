package com.example.demo.service;

import com.example.demo.model.Envio;
import com.example.demo.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioService {

    public double calcularTotalPedido(Pedido pedido) {
        return pedido.calcularCostoTotal();
    }

    public void notificarEnvios(List<Envio> envios, String mensaje) {
        for (Envio envio : envios) {
            envio.enviarNotificacion(mensaje);
        }
    }
}
