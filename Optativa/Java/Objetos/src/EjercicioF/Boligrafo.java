package Optativa.Java.Objetos.src.EjercicioF;

public class Boligrafo {

    private String modelo;
    private double precio;

    public Boligrafo(String modelo, double precio) {
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "modelo: " + modelo + ", precio: " + precio + "€";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        long temp;
        temp = Double.doubleToLongBits(precio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Boligrafo other = (Boligrafo) obj;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
            return false;
        return true;
    }

}
