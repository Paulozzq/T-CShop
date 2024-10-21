package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.modelo.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendVerificationEmail(Usuario usuario) {
        String subject = "Verifica tu cuenta";
        String verificationUrl = "http://localhost:8086/api/verify?token=" + usuario.getToken();
        String text = "Bienvenido " + usuario.getUsername() + ",\nPor favor, verifica tu cuenta haciendo clic en el siguiente enlace:\n" + verificationUrl;

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(usuario.getEmail());
            message.setFrom("paulo.garcia@tecsup.edu.pe");
            message.setSubject(subject);
            message.setText(text);
            mailSender.send(message);
        } catch (MailException e) {
            System.out.println("Error sending email: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
