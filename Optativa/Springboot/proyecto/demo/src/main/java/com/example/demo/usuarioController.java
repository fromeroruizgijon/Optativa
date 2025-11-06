package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class usuarioController {

    @RequestMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @RequestMapping("/procesarLogin")
    public String procesarLogin(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "password") String password) {
        Usuario user = new Usuario("usuario", "password", "email", Roles.admin);
        if(nombre.equals(user.getNombre()) && password.equals(user.getPassword())){
            return "index";
        }else{
            return "login";
        }
        
    }
    
}
