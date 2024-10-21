package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.dto.LoginDto;
import com.tcshop.tcshopspring.modelo.daos.UsuarioRepository;
import com.tcshop.tcshopspring.modelo.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Usuario loginUser(LoginDto loginDto) {
        Optional<Usuario> optionalUser = userRepository.findByEmail(loginDto.getIdentifier());
        if (!optionalUser.isPresent()) {
            optionalUser = userRepository.findByUsername(loginDto.getIdentifier());
        }

        Usuario usuario = optionalUser.orElseThrow(() ->
                new RuntimeException("Usuario no encontrado"));

        if (passwordEncoder.matches(loginDto.getPassword(), usuario.getPassword())) {
            return usuario;
        } else {
            throw new RuntimeException("Contraseña inválida");
        }
    }
}