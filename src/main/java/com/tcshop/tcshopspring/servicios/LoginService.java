    package com.tcshop.tcshopspring.servicios;

    import com.tcshop.tcshopspring.dto.LoginDto;
    import com.tcshop.tcshopspring.modelo.entidades.Usuario;

    public interface LoginService {
        Usuario loginUser(LoginDto loginDto);
    }