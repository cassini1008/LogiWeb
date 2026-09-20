package com.example.demo.repository;

import com.example.demo.model.Pedido;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoRepository {

    private Pedido pedido;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}