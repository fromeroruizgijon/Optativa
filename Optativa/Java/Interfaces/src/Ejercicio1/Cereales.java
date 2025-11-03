package Ejercicio1;

import java.time.LocalDate;

public class Cereales extends Producto implements EsAlimento {
    private TipoCereral tipo;
    private LocalDate caducidad;
    private int calorias;

    public Cereales(String marca, double precio, TipoCereral tipo, LocalDate caducidad, int calorias) {
        super(marca, precio);
        this.tipo = tipo;
        this.caducidad = caducidad;
        this.calorias = calorias;
    }

    public TipoCereral getTipo() {
        return tipo;
    }

    public void setTipo(TipoCereral tipo) {
        this.tipo = tipo;
    }

    public LocalDate getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(LocalDate caducidad) {
        this.caducidad = caducidad;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        return "Cereales: tipo:" + tipo + ", caducidad:" + caducidad + ", calorias:" + calorias + ", marca:"
                + getMarca() + ", precio: " + getPrecio() + "€";
    }

}
