package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.EnvioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class EnvioController {

    private final EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @GetMapping("/")
    public String index(Model model) {
        Pedido pedido = envioService.getPedidoActual();
        model.addAttribute("cliente", pedido.getCliente());
        model.addAttribute("envios", pedido.getEnvios());
        model.addAttribute("totalPedido", envioService.calcularTotalPedido(pedido));
        return "index";
    }

    @GetMapping("/cliente/nuevo")
    public String formCliente() {
        return "cliente-form";
    }

    @PostMapping("/cliente/nuevo")
    public String crearCliente(@RequestParam String nombre, @RequestParam String email,
                                @RequestParam String telefono, @RequestParam String calle,
                                @RequestParam String ciudad, @RequestParam String codigoPostal) {
        Cliente cliente = new Cliente(System.currentTimeMillis(), nombre, email, telefono,
                calle, ciudad, codigoPostal);
        envioService.registrarCliente(cliente);
        return "redirect:/";
    }

    @GetMapping("/envio/terrestre/nuevo")
    public String formTerrestre() {
        return "envio-terrestre-form";
    }

    @PostMapping("/envio/terrestre/nuevo")
    public String crearTerrestre(@RequestParam String codigo, @RequestParam String origen,
                                  @RequestParam String destino, @RequestParam double pesoKg,
                                  @RequestParam String placa, @RequestParam String tipoVehiculo,
                                  @RequestParam double capacidadKg, @RequestParam double distanciaKm) {
        Vehiculo vehiculo = new Vehiculo(placa, tipoVehiculo, capacidadKg);
        EnvioTerrestre envio = new EnvioTerrestre(codigo, origen, destino, pesoKg,
                LocalDate.now(), vehiculo, distanciaKm);
        envioService.agregarEnvio(envio);
        return "redirect:/";
    }

    @GetMapping("/envio/aereo/nuevo")
    public String formAereo() {
        return "envio-aereo-form";
    }

    @PostMapping("/envio/aereo/nuevo")
    public String crearAereo(@RequestParam String codigo, @RequestParam String origen,
                              @RequestParam String destino, @RequestParam double pesoKg,
                              @RequestParam String codigoVuelo, @RequestParam String pais,
                              @RequestParam double impuesto) {
        Aduana aduana = new Aduana(pais, impuesto);
        EnvioAereo envio = new EnvioAereo(codigo, origen, destino, pesoKg,
                LocalDate.now(), codigoVuelo, aduana);
        envioService.agregarEnvio(envio);
        return "redirect:/";
    }
}