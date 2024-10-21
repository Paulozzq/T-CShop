package com.tcshop.tcshopspring.servicios;


import com.tcshop.tcshopspring.modelo.daos.UsuarioRepository;
import com.tcshop.tcshopspring.modelo.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailServiceImpl emailService;

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setToken(UUID.randomUUID().toString());
        usuario.setEnable(false);
        usuario.setRegisterDate(new Timestamp(System.currentTimeMillis()));

        usuarioRepository.save(usuario);

        emailService.sendVerificationEmail(usuario);
        return usuario;
    }

    @Override
    public Usuario verificarToken(String token) {
        return usuarioRepository.findByToken(token).orElse(null);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
