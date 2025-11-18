package examen.examen1;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Component
@AllArgsConstructor
public class Autor {
    private String nombre;
    private String password;
    public Autor() {
    }
}
