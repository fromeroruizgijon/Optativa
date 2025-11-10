package com.example.demo;

import java.time.LocalDate;
import java.util.ArrayList;

public class TareaPrincipal extends Tarea{

    private ArrayList<TareaSecundaria> tareasSecundarias;
    
    public TareaPrincipal(ArrayList<TareaSecundaria> tareaSecundarias,String titulo, String description, boolean estado, int prioridad, LocalDate fechaCreacion) {
        super(titulo, description, estado, prioridad, fechaCreacion);
        this.tareasSecundarias = tareaSecundarias;
    }
    public ArrayList<TareaSecundaria> getTareasSecundarias() {
        return tareasSecundarias;
    }
    public void setTareasSecundarias(ArrayList<TareaSecundaria> tareasSecundarias) {
        this.tareasSecundarias = tareasSecundarias;
    }
    public void insertarSubtarea(TareaSecundaria tarea){
        tareasSecundarias.add(tarea);
    }
    public void eliminarSubtarea(TareaSecundaria tarea){
        tareasSecundarias.remove(tarea);
    }
    public boolean tareasCompletadas(){
        for (TareaSecundaria tarea : tareasSecundarias) {
            if(!tarea.isEstado()){
                return false;
            }
        }
        return true;
    }
    
}
