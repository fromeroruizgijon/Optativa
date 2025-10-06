package Optativa.Java.String.src;

import java.util.Scanner;

public class EjericicoA {
    public static void main(String[] args) {
    Scanner s = new Scanner (System.in);

    System.out.println("Escriba una palabra: ");
    String str1 = s.nextLine();
    System.out.println("Escriba una segunda palabra: ");
    String str2 = s.nextLine();

    Funciones.QuitaCaracteres(str1, str2);
        s.close();
    }
}
