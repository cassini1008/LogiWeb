package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.model.Envio;
import com.example.demo.model.EnvioAereo;
import com.example.demo.model.EnvioTerrestre;
import com.example.demo.model.Pedido;
import com.example.demo.service.EnvioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EnvioController {

    private final EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @GetMapping("/")
    public String index(Model model) {
        Cliente cliente = new Cliente(1L, "Ana García", "ana@logiweb.com", "555123456");

        EnvioTerrestre terrestre = new EnvioTerrestre(
                "ENV-1001",
                "Bogotá",
                "Medellín",
                18.5,
                LocalDate.now(),
                "ABC-123",
                250
        );

        EnvioAereo aereo = new EnvioAereo(
                "ENV-2002",
                "Cali",
                "Miami",
                12.0,
                LocalDate.now(),
                "AV-770"
        );

        terrestre.calcularCosto();
        aereo.calcularCosto();

        Pedido pedido = new Pedido(cliente);
        pedido.agregarEnvio(terrestre);
        pedido.agregarEnvio(aereo);

        List<Envio> envios = pedido.getEnvios();

        model.addAttribute("cliente", cliente);
        model.addAttribute("envios", envios);
        model.addAttribute("totalPedido", envioService.calcularTotalPedido(pedido));

        return "index";
    }
}
