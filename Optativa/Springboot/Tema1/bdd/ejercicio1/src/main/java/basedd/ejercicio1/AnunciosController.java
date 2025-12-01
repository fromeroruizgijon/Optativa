package basedd.ejercicio1;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


@Controller
public class AnunciosController {
    @GetMapping("/inicio")
    public String mostrarPagina() {
        return "inicio";
    }
    @GetMapping("/nuevoAnuncio")
    public String mostrarPagina2() {
        return "nuevoAnuncio";
    }
    @GetMapping("/final")
    public String getMethodName(@RequestParam(name = "id2")int id2, HttpSession session) {
        session.setAttribute("id2", id2);
        return "final";
    }
    
    @GetMapping("/datosCorrectos")
    public String recogerDatos(@RequestParam(name = "nombre")String nombre, @RequestParam(name = "asunto")String asunto, @RequestParam(name = "descripcion")String descripcion, HttpSession session){
        ArrayList<Anuncio> lista;
        if(session.getAttribute("lista") == null){
            lista = new ArrayList<>();
        }else{
            lista = (ArrayList<Anuncio>) session.getAttribute("lista");
        }
        lista.add(new Anuncio(nombre, asunto, descripcion));
        session.setAttribute("lista", lista);
        return "datosCorrectos";
    }
    
}
