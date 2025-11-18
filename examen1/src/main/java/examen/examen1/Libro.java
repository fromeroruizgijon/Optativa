package examen.examen1;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
@Data
@AllArgsConstructor
public class Libro {
    private String titulo;
    private String autor;
    private int precio;
    private int isbn;
    public Libro() {} 
}
