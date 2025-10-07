package Ejercicio1;

import java.time.LocalDate;

public interface EsAlimento {

    public void setCaducidad(LocalDate caducidad);
    public LocalDate getCaducidad();
    public int getCalorias();

}
