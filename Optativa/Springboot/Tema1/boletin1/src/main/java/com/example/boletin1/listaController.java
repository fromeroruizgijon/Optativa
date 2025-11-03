package com.example.boletin1;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class listaController {
@GetMapping("lista")
public String lista(Model model) {
    ArrayList<Persona> lista = new ArrayList<>();
    lista.add(new Persona("26/10/25", "fran", "Romero", "usuario@usuario.usuario", "Hombre"));
    lista.add(new Persona("26/10/25", "Paula", "Agilar", "usuario@usuario.usuario", "Mujer"));
    model.addAttribute("lista", lista);
    return "lista";
}

}
