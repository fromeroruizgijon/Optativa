package com.spring.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http){

        http.authorizeHttpRequests(authorize -> 
            authorize.anyRequest().authenticated()
        ).oauth2Login(Customizer.withDefaults());

        return http.build();

    }


}
