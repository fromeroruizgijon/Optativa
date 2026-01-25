package com.security.memoria;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String index() {
        return "<h1>Panel de Control</h1>" +
               "<ul>" +
               "<li><a href='/usuario/perfil'>Ir a mi Perfil (USER y ADMIN)</a></li>" +
               "<li><a href='/admin/gestion'>Ir a Gestión (Solo ADMIN)</a></li>" +
               "</ul>";
    }

    @GetMapping("/usuario/perfil")
    public String perfil() {
        return "<h1>Área de Usuario</h1><p>Bienvenido a tu perfil privado.</p>";
    }

    @GetMapping("/admin/gestion")
    public String gestion() {
        return "<h1>Área de Administración</h1><p>Bienvenido, Jefe. Aquí puedes gestionar la web.</p>";
    }
}
