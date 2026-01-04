package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;





@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping("/login")
    public String mostrarLogin() {
        return "login";
    }
    @RequestMapping("/registro")
    public String mostrarRegistro() {
        return "registro";
    }
    

    @RequestMapping("/procesarLogin")
    public String procesarLogin(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "password") String password, HttpSession session) {
        //he sustituido todo el método que tenía hecho por que con la base de datos se simplifica mucho
       Usuario usuarioLogeado = usuarioRepository.findByNombreAndPassword(nombre, password);
       if(usuarioLogeado != null){
        session.setAttribute("usuario", usuarioLogeado);
        return "redirect:/";
       }else{
        return "redirect:/registro?error=true";
       }
    }
    @RequestMapping("/insertarUsuario")
    public String procesarRegistro(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "email") String email, @RequestParam(name = "password") String password){
        Usuario nuevoUsuario = new Usuario (nombre, password, email, Roles.normal);
        usuarioRepository.save(nuevoUsuario);
        return "redirect:/login";
    }
    
    /*public ArrayList<Usuario> rescatarUsuarios(HttpServletRequest request){

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        if(request.getCookies() != null){
            for (Cookie cookie : request.getCookies()) {
                if(cookie.getName().equals("usuarios")){
                    String valor = cookie.getValue();
                    String[] usuariosSeparados = valor.split("\\|");
                    for (String datosU : usuariosSeparados) {
                        String[] partes = datosU.split("_");
                        if(partes.length == 3){
                            listaUsuarios.add(new Usuario(partes[0], partes[1], partes[2], Roles.normal));
                        }
                    }
                }
            }
        }
        return listaUsuarios;
    }*/
    @RequestMapping("/cerrarSesion")
    public String cerrarSesion(HttpSession session) {
       session.invalidate();
        return "login";
    }
    
}
