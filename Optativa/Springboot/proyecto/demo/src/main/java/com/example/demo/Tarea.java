package com.example.demo;

import java.time.LocalDate;

public class Tarea implements Comparable<Tarea> {
    private String titulo;
    private String description;
    private boolean estado;
    private int prioridad;
    private LocalDate fechaCreacion;

    public Tarea(String titulo, String description, boolean estado, int prioridad, LocalDate fechaCreacion) {
        this.titulo = titulo;
        this.description = description;
        this.estado = estado;
        this.prioridad = prioridad;
        this.fechaCreacion = fechaCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void marcarDesmarcar() {
        if (this.estado) {
            this.estado = false;
        } else {
            this.estado = true;
        }
    }

    @Override
    public String toString() {
        return "Tarea: titulo: " + titulo + ", description: " + description + ", estado: " + estado + ", prioridad: "
                + prioridad + ", fechaCreacion: " + fechaCreacion;
    }

    @Override
    public int compareTo(Tarea o) {
       if (this.prioridad < o.prioridad) return -1;
        if (this.prioridad > o.prioridad) return 1;
        return 0;
    }

}
