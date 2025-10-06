package Optativa.Java.String.src;

import java.util.Scanner;

public class EjercicioB {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean salir = false;
        String fecha1 = "";
        String fecha2 = "";
        System.out.println("Buenvenido al restador de fecha. El formato de una es dd/MM/yy");
        do{
            System.out.println("Escriba la primera fecha: ");
            fecha1 = s.nextLine();
            System.out.println("Escriba la segunda fecha: ");
            fecha2 = s.nextLine();

            if(fecha1.equals("/")){

            }
        }while(!salir);
        s.close();
    }
}
