package Ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<EsAlimento> alimentos = new ArrayList<>();
        ArrayList<ConDescuento> liquidos = new ArrayList<>();
        alimentos.add(new Cereales("Oarmeal", 3.0, TipoCereral.avena, LocalDate.of(2025, 07, 01), 5));
        alimentos.add(new Cereales("Fitness fiber", 2.25, TipoCereral.trigo, LocalDate.of(2025, 04, 20), 12));
        alimentos.add(new Vino("MarcaVino1", 8.0, "tinto", 12, LocalDate.of(2025, 07, 01), 120, 700,
                "Botella_de_cristal", 5.0, 7.6));
        alimentos.add(new Vino("MarcaVino2", 5.3, "rosado", 12, LocalDate.of(2025, 03, 03), 60, 330,
                "Botella_de_Cristal", 5.0, 4.035));

        liquidos.add(new Detergente("agerul", 6.0, 5000, "Botella_de_plastico_grande", 20.0, 4.8));
        liquidos.add(new Detergente("dixan", 4.0, 2500, "Botella_de_plastico_mediana", 10.0, 1.225));
        liquidos.add(new Detergente("norit", 1.25, 500, "Botella_de_plastico_mediana", 2.0, 1.225));

        int caloriasTotales = 0;
        System.out.println("Listado de alimentos");
        for (EsAlimento alimento : alimentos) {
            System.out.println(alimento);
            caloriasTotales = caloriasTotales + alimento.getCalorias();
        }
        System.out.println("Total de calorías: " + caloriasTotales);

        System.out.println();
        double ahorro = 0;
        System.out.println("Listado de líquidos: ");
        for (ConDescuento liquido : liquidos) {
            System.out.println(liquido);
            ahorro += (liquido.getPrecioDescuento() / (1 - liquido.getDescuento() / 100))
                    - liquido.getPrecioDescuento();
        }
        System.out.println("Dinero ahorrado: " + ahorro + "€");
    }
}
