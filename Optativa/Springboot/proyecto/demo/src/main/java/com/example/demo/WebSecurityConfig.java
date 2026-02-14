package com.example.demo; // Todo en el mismo paquete

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                // Rutas públicas: Login, Registro, CSS, JS, etc.
                .requestMatchers("/", "/login", "/registro", "/insertarUsuario", "/css/**", "/js/**", "/images/**").permitAll()
                // Cualquier otra cosa requiere login
                .anyRequest().authenticated()
            )
            .formLogin((form) -> form
                .loginPage("/login") // Tu HTML de login
                .usernameParameter("email") // Importante: usas email como usuario
                .defaultSuccessUrl("/", true) // A dónde va si entra bien
                .permitAll()
            )
            .logout((logout) -> logout
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) 
            
            .logoutSuccessUrl("/login?logout") // A donde vas al salir
            .permitAll()
        );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
