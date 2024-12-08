package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.modelo.daos.UsuarioRepository;
import com.tcshop.tcshopspring.modelo.entidades.Usuario;
import com.tcshop.tcshopspring.security.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public JwtUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // Devolver un CustomUserDetails con el username, email, contraseña y roles
        return new CustomUserDetails(
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getPassword(),
                Collections.singleton(usuario.getRol()) // Aquí asumimos que un usuario tiene un solo rol
        );
    }
}
