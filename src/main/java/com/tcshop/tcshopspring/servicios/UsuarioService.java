package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.modelo.entidades.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario save(Usuario usuario);
    Optional<Usuario> findById(Integer id);
    List<Usuario> findAll();
    void deleteById(Integer id);
    Optional<Usuario> findByUsername(String username);
}
