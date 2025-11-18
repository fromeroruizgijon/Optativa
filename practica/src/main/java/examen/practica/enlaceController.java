package examen.practica;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class enlaceController {

    @RequestMapping("/Ejercicio3")
    public String muestraEjercicio3() {
        return "Ejercicio3";
    }

    @RequestMapping("/resultado3")
    public String muestraResultado() {
        return "resultado3";
    }
    
    
    @RequestMapping("/enlace")
    public String requestMethodName(@RequestParam(name = "id") int id, Model model) {
        model.addAttribute("id", id);
        return "resultado3";
    }
    
    
}