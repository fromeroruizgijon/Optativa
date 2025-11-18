package examen.practica;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMethod;






@Controller
public class anuncio4Controller {
    
    @RequestMapping("/nuevoAnuncio")
    public String creaAnuncio() {
        return "anuncioForm";
    }

    @RequestMapping("/volver")
    public String muestraVolver() {
        return "volver";
    }
    

    @RequestMapping("/Ejercicio4")
    public String devuelveAnuncios(HttpSession session, Model model) {
        if(session.getAttribute("listaAnuncios") != null){
            ArrayList<Anuncio> listaAnuncios = (ArrayList<Anuncio>) session.getAttribute("listaAnuncios");
            model.addAttribute("listaAnuncios", listaAnuncios);
        }else{
            boolean existe = true;
            String bienvenida = "Bienvenido";
            model.addAttribute("bienvenida", bienvenida);
            model.addAttribute("existe", existe);
        }

        return "Ejercicio4";
    }
    
    @RequestMapping("/procesaAnuncio")
    public String procesaAnuncio(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "asunto")String asunto, @RequestParam(name = "comentario")String comentario, HttpSession session, Model model) {
        ArrayList<Anuncio> listaAnuncios = (ArrayList<Anuncio>) session.getAttribute("listaAnuncios");
        if (listaAnuncios == null) {
                listaAnuncios = new ArrayList<>();
            }
        listaAnuncios.add(new Anuncio(nombre, asunto, comentario));
        session.setAttribute("listaAnuncios", listaAnuncios);
        return "volver";
    }

    @RequestMapping("/detalle")
    public String mostrarDetalle(@RequestParam(name = "anuncio")Anuncio anuncio, Model model) {
        //esto no se puede hacer, no se pueden pasar objetos por el modelo
        model.addAttribute("anuncio", anuncio);
        return "detalle";
    }
    
    //excepción
//     try {
//     // código que puede fallar
// } catch (Exception e) {
//     System.out.println("Ha ocurrido un error: " + e.getMessage());
// }

}
