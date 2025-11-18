package examen.practica;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Component
@AllArgsConstructor
public class Anuncio implements Comparable<Anuncio>{
    private String nombre;
    private String asunto;
    private String descripcion;
    
    public Anuncio() {
    }

    @Override
    public int compareTo(Anuncio otro) {
        return this.descripcion.length() - otro.descripcion.length();
    }

   
}
