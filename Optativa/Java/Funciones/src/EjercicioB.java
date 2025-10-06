package Optativa.Java.Funciones.src;

import java.util.Scanner;

public class EjercicioB {
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        System.out.println("Escriba un numero: ");
        int num = s.nextInt();
        Funciones.EjercicioB(num);
        s.close();
    }
}
