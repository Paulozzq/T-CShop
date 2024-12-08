package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.Util.JwtTokenUtil;
import com.tcshop.tcshopspring.dto.LoginDto;
import com.tcshop.tcshopspring.modelo.daos.UsuarioRepository;
import com.tcshop.tcshopspring.modelo.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public String loginUser(LoginDto loginDto) {
        Optional<Usuario> optionalUser = userRepository.findByEmail(loginDto.getIdentifier());
        if (!optionalUser.isPresent()) {
            optionalUser = userRepository.findByUsername(loginDto.getIdentifier());
        }

        Usuario usuario = optionalUser.orElseThrow(() ->
                new RuntimeException("Usuario no encontrado"));

        if (passwordEncoder.matches(loginDto.getPassword(), usuario.getPassword())) {
            UserDetails userDetails = new User(usuario.getUsername(), usuario.getPassword(),
                    Collections.singletonList((org.springframework.security.core.GrantedAuthority) usuario.getRol()));
            return jwtTokenUtil.generateToken(userDetails);
        } else {
            throw new RuntimeException("Contraseña inválida");
        }
    }
}