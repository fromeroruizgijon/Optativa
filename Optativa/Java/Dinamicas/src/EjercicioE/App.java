package Optativa.Java.Dinamicas.src.EjercicioE;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean salir = false;
        ArrayList<String> lista = new ArrayList<>();

        do {
            System.out.println("LLenar y vaciar un array");
            System.out.println("1. LLenar");
            System.out.println("2. Mostrar");
            System.out.println("3. Vaciar");
            System.out.println("4. comprobar si está vacío");
            System.out.println("5. Remplazar un elemento de la lista");
            System.out.println("6. Salir");
            int decision = s.nextInt();
            // limpieza de buffer
            s.nextLine();
            switch (decision) {
                case 1:
                    System.out.println("Escriba la palabra que quieres añadir a la lista: ");
                    lista.add(s.nextLine());
                    break;
                case 2:
                    System.out.println("Tamaño de la lista: ");
                    lista.trimToSize();
                    System.out.println(lista.size());
                    System.out.println("Contenido de la lista: ");
                    int contador = 0;
                    for (String palabra : lista) {
                        contador++;
                        System.out.println(contador + ". " + palabra);
                    }
                    break;
                case 3:
                    lista.clear();
                    break;
                case 4:
                    if (lista.isEmpty()) {
                        System.out.println("La lista está vacía");
                    } else {
                        System.out.println("La lista no está vacía");
                    }
                    break;
                case 5:
                    System.out.println("Introduzca el número del elemento");
                    int numElemento = s.nextInt();
                    System.out.println("Introduzca el nuevo elemento: ");
                    String elmento = s.nextLine();
                    lista.set(numElemento, elmento);
                    break;
                case 6:
                    salir = true;
                    break;
            }

        } while (!salir);
        s.close();
    }
}
