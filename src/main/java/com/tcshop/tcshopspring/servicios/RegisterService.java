package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.modelo.entidades.Usuario;

public interface RegisterService {
    Usuario registrarUsuario(Usuario usuario);
    Usuario verificarToken(String token);
    void actualizarUsuario(Usuario usuario);
}
