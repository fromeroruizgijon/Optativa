package examen.examen1;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;





@Controller
public class autorController {
    @RequestMapping("/login")
    public String muestraLogin() {
        return "login";
    }
    @RequestMapping("/")
    public String MuestraIndex() {
        return "index";
    }
    
    
    @RequestMapping("/procesalogin")
    public String procesLogin(@RequestParam(name = "usuario") String usuario, HttpSession session, Model model) {
        ArrayList<String> autores = new ArrayList<>();
        ArrayList<Autor> usuarios = new ArrayList<>();
        ArrayList<String> passwords = new ArrayList<>();
        autores.add("Cervantes");
        autores.add("Lorca");
        autores.add("Zafón");
        for (String nombre : autores) {
           String password = nombre.substring(0,1) + nombre.length();
           usuarios.add(new Autor(nombre, password));
           passwords.add(password);
        }

        boolean existe = false;
        for (Autor autor : usuarios) {
            if(usuario.equalsIgnoreCase(autor.getNombre())){
                existe = true;
                session.setAttribute("usuarioLog", autor.getNombre());
            }
        }
        model.addAttribute("autores", autores);
            model.addAttribute("paswords", passwords);
        if(existe == true){
            return "index";
        }else{
            String aviso = "Usuario no registrado";
            model.addAttribute("aviso", aviso);
        return "login";
        }
    }
    @RequestMapping("/cerrarSesion")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "login";
    }
    
    
}
