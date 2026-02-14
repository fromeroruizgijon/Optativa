package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreo(String destinatario, String asunto, String cuerpo) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("informaticafrv1@gmail.com"); 
            
            message.setTo(destinatario);
            message.setSubject(asunto);
            message.setText(cuerpo);

            mailSender.send(message);
            System.out.println("Correo enviado a: " + destinatario);
            
        } catch (Exception e) {
            System.err.println("Error enviando correo: " + e.getMessage());
        }
    }
}
