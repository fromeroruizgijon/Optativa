package examen.practica;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class usuarioComtroller {
    @RequestMapping("/Ejercicio2")
    public String muestraUsuarios(Model model) {
        ArrayList<Usuario> lista = new ArrayList<>();
        Usuario fran = new Usuario("fran", "romero", "fran@correo.com", "hombre");
        Usuario paula = new Usuario("paula", "aguilar", "paula@correo.com", "Mujer");
       lista.add(fran);
       lista.add(paula);
       model.addAttribute("lista", lista);
        return "Ejercicio2";
    }
    
}
