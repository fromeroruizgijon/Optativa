package Optativa.Java.Objetos.src.EjercicioA;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        boolean salir = false;
        Cuenta cuenta = new Cuenta("usuario", 100);

        do{
            System.out.println("Qué quiere hacer con su cuenta?");
            System.out.println("1. ingresar dinero");
            System.out.println("2. retirar dinero");
            System.out.println("3. salir");
            int decision = s.nextInt();
            switch (decision) {
                case 1:
                    System.out.println("Escriba que cantidad quiere ingresar: ");
                    double ingresar = s.nextDouble();
                    cuenta.ingresar(ingresar, cuenta);
                    break;
                case 2:
                System.out.println("Escriba que cantidad quiere retirar");
                double retirar = s.nextDouble();
                cuenta.retirar(retirar, cuenta);
                    break;
                case 3:
                    salir = true;
                break;
            }


        }while(!salir);
        s.close();
    }
}
