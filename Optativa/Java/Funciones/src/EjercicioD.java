package Optativa.Java.Funciones.src;

import java.util.Scanner;

public class EjercicioD {
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);

        boolean salir = false;
        String invertido = "";
        String binario = "";

        System.out.println("Escriba un numero: ");
        int num = s.nextInt();
        while(!salir){

            if(num > 0){
                invertido += Integer.toString(num % 2);
                num /= 2;
            }else{
                salir = true;
            }
        }
        for (int i = invertido.length() -1; i >=0; i--) {
                binario = binario + invertido.charAt(i);
            }
            System.out.println("El numero en binario es: "+binario);
            s.close();
    }
}
