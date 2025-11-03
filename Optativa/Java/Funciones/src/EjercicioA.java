package Optativa.Java.Funciones.src;

import java.util.Scanner;

public class EjercicioA {
    
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        
        System.out.println("escriba el primer numero: ");
        int num1 = s.nextInt();
        System.out.println("escriba el segundo numero: ");
        int num2 = s.nextInt();

        Funciones.EjercicioA(num1, num2);
        s.close();
    }

}
