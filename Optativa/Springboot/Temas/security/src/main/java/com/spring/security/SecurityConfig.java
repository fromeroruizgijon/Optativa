package com.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        // Creamos un gestor de usuarios en memoria
        var userDetailsService = new InMemoryUserDetailsManager();

        // Definimos el usuario "admin"
        UserDetails user1 = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin")) // Ciframos la contraseña
                .authorities("write") // Le damos permisos
                .build();

        // Añadimos el usuario al gestor
        userDetailsService.createUser(user1);

        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Definimos el algoritmo de encriptación (BCrypt)
        return new BCryptPasswordEncoder();
    }
}
/*
 * 1. MULTI-USUARIO VS MONO-USUARIO:
 * - En el ejercicio del application.properties, estábamos limitados a definir un único
 * usuario (spring.security.user.name).
 * - Con InMemoryUserDetailsManager, podemos crear y gestionar múltiples usuarios
 * (user1, user2, admin, etc.) simultáneamente.
 *
 * 2. SEGURIDAD ROBUSTA (ENCRIPTACIÓN):
 * - Antes, la contraseña estaba expuesta en texto plano en el archivo de propiedades.
 * - Ahora, utilizamos un PasswordEncoder (BCrypt). Esto asegura que las contraseñas
 * se gestionen como hashes seguros, protegiendo la información incluso si se accede
 * a la memoria de la aplicación.
 *
 * 3. GRANULARIDAD DE PERMISOS (AUTHORITIES):
 * - Anteriormente, el acceso era "todo o nada".
 * - Ahora podemos asignar "authorities" o roles específicos (ej. "write", "read", "ROLE_ADMIN").
 * Esto permitirá en el futuro proteger ciertas URLs para que solo usuarios con
 * permisos específicos puedan acceder a ellas.
 *
 * 4. FLEXIBILIDAD PROGRAMÁTICA:
 * - Al ser código Java, podemos añadir lógica condicional, bucles o cargar usuarios
 * desde fuentes externas en el futuro, algo imposible en un archivo estático
 * como application.properties.*/
