package com.example.boletin1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnuncioController {

    @GetMapping("/anuncio.html")
    public String metodo() {
        return "anuncio";
    }
}
