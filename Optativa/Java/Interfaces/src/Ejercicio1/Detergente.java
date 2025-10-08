package Ejercicio1;

public class Detergente extends Producto implements EsLiquido, ConDescuento {
    private int volumen;
    private String TipoEnvase;
    private double descuento;
    private double precioDescuento;

    public Detergente(String marca, double precio, int volumen, String TipoEnvase, double descuento,
            double precioDescuento) {
        super(marca, precio);
        this.volumen = volumen;
        this.TipoEnvase = TipoEnvase;
        this.descuento = descuento;
        this.precioDescuento = precioDescuento;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public String getTipoEnvase() {
        return TipoEnvase;
    }

    public void setTipoEnvase(String tipoEnvase) {
        TipoEnvase = tipoEnvase;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getPrecioDescuento() {
        return precioDescuento;
    }

    public void setPrecioDescuento(double precioDescuento) {
        this.precioDescuento = precioDescuento;
    }

    @Override
    public String toString() {
        return "Detergente: volumen: " + volumen + ", TipoEnvase:" + TipoEnvase + ", descuento:" + descuento
                + ", precioDescuento: " + precioDescuento + ", marca: " + getMarca() + ", precio: " + getPrecio()
                + "€";
    }

}
