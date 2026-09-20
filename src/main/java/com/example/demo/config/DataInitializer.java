package com.example.demo.config;

import com.example.demo.model.*;
import com.example.demo.repository.PedidoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PedidoRepository pedidoRepository;

    public DataInitializer(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void run(String... args) {
        Cliente cliente = new Cliente(1L, "Ana García", "ana@logiweb.com", "555123456",
                "Calle 45 #12-30", "Bogotá", "110111");

        Pedido pedido = new Pedido(cliente);

        Vehiculo vehiculo = new Vehiculo("ABC-123", "Camión", 500);
        pedido.agregarEnvio(new EnvioTerrestre("ENV-1001", "Bogotá", "Medellín", 18.5,
                LocalDate.now(), vehiculo, 250));

        Aduana aduana = new Aduana("Estados Unidos", 45.00);
        pedido.agregarEnvio(new EnvioAereo("ENV-2002", "Cali", "Miami", 12.0,
                LocalDate.now(), "AV-770", aduana));

        pedido.agregarPaquete("Documentos", 0.5);
        pedido.agregarPaquete("Repuestos electrónicos", 3.2);

        pedidoRepository.setPedido(pedido);
    }
}