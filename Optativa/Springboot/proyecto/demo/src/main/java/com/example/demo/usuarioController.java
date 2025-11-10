package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;





@Controller
public class usuarioController {

    //ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    //listaUsuarios.add(new Usuario("admin", "admin", "admin@hotmail.com", Roles.admin));

    @RequestMapping("/login")
    public String mostrarLogin() {
        return "login";
    }
    @RequestMapping("/registro")
    public String mostrarRegistro() {
        return "registro";
    }
    

    @RequestMapping("/procesarLogin")
    public String procesarLogin(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "password") String password, HttpServletRequest request, HttpSession session) {
       boolean entrar = false;
       ArrayList<Usuario> listaUsuarios = rescatarUsuarios(request);
        Usuario usuarioLogeado = null;

        for (Usuario usuario : listaUsuarios) {
            if(nombre.equals(usuario.getNombre()) && password.equals(usuario.getPassword())){
                entrar = true;
                if(entrar){
                    usuarioLogeado = usuario;
                }
            }
        }
        if(entrar){
            session.setAttribute("usuario", usuarioLogeado);
                return "index";
            }else{
                return "registro";
            }
    }
    @RequestMapping("/insertarUsuario")
    public String procesarRegistro(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "email") String email, @RequestParam(name = "password") String password, HttpServletRequest request, HttpServletResponse response){
        ArrayList<Usuario> listaUsuarios = rescatarUsuarios(request);
        listaUsuarios.add(new Usuario(nombre, password, email, Roles.normal));
        String usuarioStr = "";
        for (Usuario usuario : listaUsuarios) {
            usuarioStr += usuario.getNombre() + "_" + usuario.getPassword()+ "_" + usuario.getEmail() + "|";  
        }
        Cookie cookie = new Cookie("usuarios", usuarioStr);
        cookie.setMaxAge(60*60*5);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "login";
    }
    
    public ArrayList<Usuario> rescatarUsuarios(HttpServletRequest request){

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
    }
    @RequestMapping("/cerrarSesion")
    public String cerrarSesion(HttpSession session) {
       session.invalidate();
        return "login";
    }
    
}
