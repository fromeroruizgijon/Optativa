package com.example.demo;

public class Usuario {
    private String nombre;
    private String email;
    private Roles rol;

    public Usuario(String nombre, String email, Roles rol) {
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "usuario: nombre: " + nombre + ", email: " + email + ", rol: " + rol;
    }
}
