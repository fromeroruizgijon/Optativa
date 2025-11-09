package com.example.demo;

import java.time.LocalDate;

public class TareaSecundaria extends Tarea {

    private String categoria;

    public TareaSecundaria(String categoria, String titulo, String description, boolean estado, int prioridad, LocalDate fechaCreacion) {
        super(titulo, description, estado, prioridad, fechaCreacion);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "categoria:" + categoria;
    }
    
}
