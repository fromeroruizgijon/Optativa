package examen.practica;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Usuario {
    private String nombre;
    private String apellido;
    private String correo;
    private String sexo;


}
