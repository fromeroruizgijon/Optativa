package com.example.boletin1;

public class Anuncio {
public static int id2 = 0;
private int id;
private String nombre;
private String asunto;
private String descripcion;

public Anuncio(String nombre, String asunto, String descripcion) {
    this.id = id2;
    this.nombre = nombre;
    this.asunto = asunto;
    this.descripcion = descripcion;
    id2++;
}
public int getId(){
return id;
}
public void setId(int id){
    this.id = id;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getAsunto() {
    return asunto;
}

public void setAsunto(String asunto) {
    this.asunto = asunto;
}

public String getDescripcion() {
    return descripcion;
}

public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}

}
