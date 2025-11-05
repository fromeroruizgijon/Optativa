package com.example.demo;

import java.util.ArrayList;

public class Proyecto {
    private String nombre;
    private String descripcion;
    private ArrayList<Tarea> tareas;
    private Usuario creador;

    public Proyecto(String nombre, String descripcion, ArrayList<Tarea> tareas, Usuario creador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tareas = tareas;
        this.creador = creador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public void insertarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public void eliminarTarea(Tarea tarea) {
        tareas.remove(tarea);
    }

    public double getPorcentajeCompletado(Proyecto proyecto) {

        double completadas = 0;
        double total = proyecto.tareas.size();

        for (Tarea tarea : proyecto.tareas) {
            if (tarea.isEstado() == true) {
                completadas++;
            }
        }
        return completadas / total;
    }

    public ArrayList<Tarea> ordenarPorPrioridad(Proyecto proyecto) {

        // ni zorra de como ordenar pa más adelante

        return proyecto.tareas;
    }

    @Override
    public String toString() {
        return "Proyecto: nombre: " + nombre + ", descripcion: " + descripcion + ", tareas: " + tareas + ", creador: "
                + creador;
    }

}
