package examen.practica;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;



@Controller
public class nombreController {

    @RequestMapping("sesion")
    public String devuelveIndex(HttpSession session, Model model) {
        String nombre = (String) session.getAttribute("nombre");
        model.addAttribute("nombre", nombre);
        Integer contador = (Integer) session.getAttribute("contador");
        if(contador != null){
             contador--;
        
            if(contador < 0){
                String aviso = "tu contador ha llegado a cero y se ha borrado tu sesión";
                model.addAttribute("aviso", aviso);
                 model.addAttribute("contador", 0);
                session.invalidate();
            }else{
                session.setAttribute("contador", contador);
                model.addAttribute("contador", contador);
            }
        }
        return "sesion";
    }
    
    @RequestMapping("/guardaNombre")
    public String devuelveNombre(@RequestParam(name = "nombre") String nombre, HttpSession session, Model model) {
        if (session.getAttribute("nombre") == null) {
            session.setAttribute("nombre", nombre);
            Integer contador = 5;
            session.setAttribute("contador", contador);
            model.addAttribute("contador", contador);
        }
        model.addAttribute("nombre", nombre);
        return "sesion";
    }
    

}