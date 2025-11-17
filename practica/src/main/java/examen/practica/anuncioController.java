package examen.practica;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class anuncioController {
    @RequestMapping("/Ejercicio1")
    public String MuestraEjercicio1() {
        return "Ejercicio1";
    }
    
    @RequestMapping("/crearAnuncios")
    public String crearAnuncios(@RequestParam(name = "nombre")String nombre, @RequestParam(name ="asunto") String asunto, @RequestParam(name = "cuerpo")String cuerpo, Model model) {
        model.addAttribute("nombre", nombre);
        model.addAttribute("asunto", asunto);
        model.addAttribute("cuerpo", cuerpo);
        return "Anuncio1";
    }
    
}
