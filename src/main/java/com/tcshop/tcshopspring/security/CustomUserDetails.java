package com.tcshop.tcshopspring.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    // Constructor
    public CustomUserDetails(String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return username; // Devuelve el 'username' (puede ser nombre de usuario o cualquier identificador único)
    }

    public String getEmail() {
        return email; // Devuelve el 'email'
    }

    @Override
    public String getPassword() {
        return password; // Devuelve la contraseña del usuario
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities; // Devuelve los roles o permisos del usuario
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Indica si la cuenta no ha expirado
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Indica si la cuenta no está bloqueada
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Indica si las credenciales no han expirado
    }

    @Override
    public boolean isEnabled() {
        return true; // Indica si el usuario está habilitado
    }
}
