package basedd.ejercicio1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Anuncios")
public class Anuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

private String nombre;
private String asunto;
private String descripcion;

public Anuncio(){}

public Anuncio(String nombre, String asunto, String descripcion) {
    this.nombre = nombre;
    this.asunto = asunto;
    this.descripcion = descripcion;
}
public Long getId(){
return id;
}
public void setId(Long id){
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
