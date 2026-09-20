package com.example.demo.model;

public class Cliente implements Notificable {

    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private Domicilio domicilio;   

    public Cliente(Long id, String nombre, String email, String telefono, String calle, String ciudad, String codigoPostal) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.domicilio = new Domicilio(calle, ciudad, codigoPostal); 
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Enviando notificación a " + email + ": " + mensaje);
    }

    public Domicilio getDomicilio() {
        return domicilio;
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
