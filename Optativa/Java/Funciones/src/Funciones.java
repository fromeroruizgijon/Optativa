package Optativa.Java.Funciones.src;

public class Funciones {

    public static void EjercicioA(int num1, int num2){
        int max = 0;
        int min = 0;
        boolean salir = false;
        if(num1 > num2){
            min = num2;
            max = num1;
        }else{
            min = num1;
            max = num2;
        }

        while(!salir){
            if(min <= max){
                System.out.print(min + ", ");
                min+=1;
            }else{
                salir = true;
            }
        }

    }

    public static void EjercicioB(int num){

        int contador = 0;
        int suma = 0;
        boolean salir = false;
        while(!salir){
            if(contador <= num){
                if(contador % 2 != 0){
                    suma+=contador;
                }
                contador++;
            }else{
                salir = true;
            }
        }
        System.out.println("La suma de los impares es: "+suma);
    }

}
