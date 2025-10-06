package Optativa.Java.Objetos.src.EjercicioE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class App {
    public static void main(String[] args) {
        ArrayList<Telefono> telefonos = new ArrayList<>();
        telefonos.add(new Telefono("iPhone 12 Pro Max", 1259));
        telefonos.add(new Telefono("Xiaomi Mi 10 Pro", 999));
        telefonos.add(new Telefono("Huawei P40 Pro+", 1399));
        telefonos.add(new Telefono("Samsung Z Flip 5G", 1550));
        telefonos.add(new Telefono("Samsung S20", 1500));
        telefonos.add(new Telefono("LG V50", 899));
        telefonos.add(new Telefono("Xiaomi Mi 10 Pro", 999));
        telefonos.add(new Telefono("Huawei P40 Pro+", 1399));
        telefonos.add(new Telefono("Samsung Z Flip 5G", 1550));
        telefonos.add(new Telefono("Samsung S30", 1300));
        telefonos.add(new Telefono("Huawei P50 Pro+", 1399));
        telefonos.add(new Telefono("Samsung Z Flip 5G", 1550));

        Collections.sort(telefonos, new Comparator<Telefono>() {
            @Override
            public int compare(Telefono t1, Telefono t2) {
                return Integer.compare(t1.getPrecio(), t2.getPrecio());
            }
        });
        System.out.println();
        System.out.println("Lista ordenada por precio: ");
        for (Telefono telefono : telefonos) {
            System.out.println(telefono.toString());
        }
        Collections.sort(telefonos, new Comparator<Telefono>() {
            @Override
            public int compare(Telefono t1, Telefono t2) {
                return t1.getModelo().compareToIgnoreCase(t2.getModelo());
            }
        });
        System.out.println();
        System.out.println("Lista ordenada alfabéticamente: ");
        for (Telefono telefono : telefonos) {
            System.out.println(telefono.toString());
        }
    }
}
