package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.modelo.daos.UsuarioRepository;
import com.tcshop.tcshopspring.modelo.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    private final UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
