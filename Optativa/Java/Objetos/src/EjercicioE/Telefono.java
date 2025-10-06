package Optativa.Java.Objetos.src.EjercicioE;


public class Telefono {
    private String modelo;
    private int precio;

    public Telefono(String modelo, int precio){
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "modelo: "+modelo+" precio: "+precio+ " euros";
    }
    
}
