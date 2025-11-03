package Ejercicio1;

import java.time.LocalDate;

public class Vino extends Producto implements EsAlimento, EsLiquido, ConDescuento {

    private String TipoVino;
    private int grados;
    private LocalDate caducidad;
    private int calorias;
    private int volumen;
    private String TipoEnvase;
    private double Descuento;
    private double PrecioDescuento;

    public Vino(String marca, double precio, String tipoVino, int grados, LocalDate caducidad, int calorias,
            int volumen, String tipoEnvase, double descuento, double precioDescuento) {
        super(marca, precio);
        TipoVino = tipoVino;
        this.grados = grados;
        this.caducidad = caducidad;
        this.calorias = calorias;
        this.volumen = volumen;
        TipoEnvase = tipoEnvase;
        Descuento = descuento;
        PrecioDescuento = precioDescuento;
    }

    public String getTipoVino() {
        return TipoVino;
    }

    public void setTipoVino(String tipoVino) {
        TipoVino = tipoVino;
    }

    public int getGrados() {
        return grados;
    }

    public void setGrados(int grados) {
        this.grados = grados;
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
        return Descuento;
    }

    public void setDescuento(double descuento) {
        Descuento = descuento;
    }

    public double getPrecioDescuento() {
        return PrecioDescuento;
    }

    public void setPrecioDescuento(double precioDescuento) {
        PrecioDescuento = precioDescuento;
    }

    @Override
    public String toString() {
        return "Vino: TipoVino: " + TipoVino + ", grados: " + grados + ", caducidad: " + caducidad + ", calorias: "
                + calorias + ", volumen: " + volumen + ", TipoEnvase: " + TipoEnvase + ", Descuento: " + Descuento
                + ", PrecioDescuento: " + PrecioDescuento + ", marca: " + getMarca() + ", precio: " + getPrecio()
                + "€";
    }

}
