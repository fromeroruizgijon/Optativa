package Optativa.Java.Matrices.src;

import java.util.Scanner;

public class EjercicioA {
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        System.out.println("Escriba el número de columnas: ");
        int n = s.nextInt();
        int[][] matriz = new int[5][n];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = funciones.aleatorio();
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j]+" | ");
            }
            System.out.println();
        }
        s.close();
    }
}
