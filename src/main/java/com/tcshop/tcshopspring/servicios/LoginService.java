    package com.tcshop.tcshopspring.servicios;

    import com.tcshop.tcshopspring.dto.LoginDto;

    public interface LoginService {
        String loginUser(LoginDto loginDto);
    }