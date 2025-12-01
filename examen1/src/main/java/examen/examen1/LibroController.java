package examen.examen1;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;



@Controller
public class LibroController {

    @RequestMapping("/librosForm")
    public String muestrForm() {
        return "librosForm";
    }

    @RequestMapping("/")
    public String MuestraIndice() {
        return "index";
    }
    

    @RequestMapping("/insertaLibro")
    public String insertarLibro(@RequestParam(name = "titulo")String titulo, @RequestParam(name = "autor" ,required=false) String autor, @RequestParam(name = "precio")int precio, @RequestParam(name = "isbn") int isbn, HttpSession session, Model model) {
       
        //esto daba fallo si no estaba todo dentro de las condiciones y no tengo tiempo para mirarlo, solo quería sacar el valor de la sesión y si no está inicializarlo
        if(session.getAttribute("contador") == null){
            int contadorLibros = 0;
            contadorLibros ++;
            session.setAttribute("contador", contadorLibros);
            model.addAttribute("contador", contadorLibros);
        }else{
            int contadorLibros = (int) session.getAttribute("contador");
            contadorLibros ++;
            session.setAttribute("contador", contadorLibros);
            model.addAttribute("contador", contadorLibros);
        }
        ArrayList<Libro> libros = new ArrayList<>();
        if(autor == null){
            autor = (String)session.getAttribute("autorLog");
        }
        libros.add(new Libro(titulo, autor, precio, isbn));

        model.addAttribute("libros",libros);
        
        
        return "/";
    }
    
}
