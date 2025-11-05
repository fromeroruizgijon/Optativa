package com.example.demo;

import java.sql.Date;

public class Tarea {
    private String titulo;
    private String description;
    private boolean estado;
    private int prioridad;
    private Date fechaCreacion;

    public Tarea(String titulo, String description, boolean estado, int prioridad, Date fechaCreacion) {
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
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

}
