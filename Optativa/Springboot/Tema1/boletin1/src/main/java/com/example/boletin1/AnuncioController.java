package com.example.boletin1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class AnuncioController {

    @GetMapping("/anuncio")
    public String metodo(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "asunto")String asunto, @RequestParam(name = "cuerpo") String cuerpo, Model model) {
        model.addAttribute("nombre", nombre);
        model.addAttribute("asunto", asunto);
        model.addAttribute("cuerpo", cuerpo);
        return "anuncio";
    }
}
