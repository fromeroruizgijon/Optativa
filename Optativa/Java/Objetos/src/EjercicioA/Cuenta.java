package Optativa.Java.Objetos.src.EjercicioA;


public class Cuenta {

    private String titular;
    private double cantidad;

    public Cuenta (String titular, double cantidad){

        this.titular = titular;
        this.cantidad = cantidad;

    }
    public Cuenta (String titular){

        this.titular = titular;

    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
   @Override
   public String toString() {
       return "Cuenta: Titular: "+this.titular+ "cantidad: "+this.cantidad;
   }

   public void ingresar(double cantidad, Cuenta cuenta){
        if(cantidad < 0){
            System.out.println("No puede introducir cantidades negativas, por favor vuelva a intentarlo");
        }else{
            System.out.println("Cantidad añadida");
            cuenta.setCantidad(cuenta.getCantidad() + cantidad);
        }
   }
   public void retirar(double cantidad, Cuenta cuenta){
    if(cuenta.getCantidad() - cantidad < 0){
        System.out.println("Su cuenta se ha quedado a 0");
        cuenta.setCantidad(0);
    }else{
        cuenta.setCantidad(cuenta.getCantidad() - cantidad);
        System.out.println("en su cuenta queda: "+ cuenta.getCantidad());
    }
   }
}

