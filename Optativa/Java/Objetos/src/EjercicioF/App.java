package Optativa.Java.Objetos.src.EjercicioF;

public class App {
    public static void main(String[] args) {
        Boligrafo boli1 = new Boligrafo("Pilot SuperBatGrip", 1);
        Boligrafo boli2 = new Boligrafo("Pilot G2", 1.3);
        Boligrafo boli3 = new Boligrafo("Bic Cristal", 0.5);
        Boligrafo boli4 = new Boligrafo("Pilot G2", 1.3);

        System.out.println("Comparación de boli1 con boli2");
        if (boli1.equals(boli2)) {
            System.out.println("los bolis son iguales");
        } else {
            System.out.println("los bolis son diferentes");
        }
        System.out.println();
        System.out.println("Comparación de boli2 con boli4");
        if (boli2.equals(boli4)) {
            System.out.println("los bolis son iguales");
        } else {
            System.out.println("los bolis son diferentes");
        }
        // me daba toc
        boli3.equals(boli4);
    }
}
