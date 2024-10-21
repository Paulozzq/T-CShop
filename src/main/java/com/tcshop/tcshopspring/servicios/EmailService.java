package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.modelo.entidades.Usuario;
import jakarta.mail.MessagingException;

public interface EmailService {
    void sendVerificationEmail(Usuario user) throws MessagingException;
}
