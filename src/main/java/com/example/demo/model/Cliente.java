package com.example.demo.model;

public class Cliente implements Notificable {

    private Long id;
    private String nombre;
    private String email;
    private String telefono;

    public Cliente(Long id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Enviando notificación a " + email + ": " + mensaje);
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }
}
