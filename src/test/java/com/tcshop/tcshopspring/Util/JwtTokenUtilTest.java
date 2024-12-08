package com.tcshop.tcshopspring.Util;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JwtTokenUtilTest {

    @Mock
    private UserDetailsService userDetailsService;

    @Test
    void validateToken() {
        // Token JWT que se va a validar
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwYXVsb3p6cTEiLCJpYXQiOjE3MzM2OTA2NDUsImV4cCI6MTczMzcyNjY0NX0.0J-37LqvR-KwAhEU-62mM7Cbe8jjnTwwk5B-KwZlELk";

        // Usuario a validar
        String username = "paulozzq1";

        UserDetails userDetails = User.builder()
                .username(username)
                .password("dummyPassword") // Usar una contraseña falsa para el test
                .roles("USER")  // O los roles que necesites
                .build();

        // Configura el mock para el UserDetailsService
        Mockito.when(userDetailsService.loadUserByUsername(username)).thenReturn(userDetails);

        // Crea una instancia de JwtTokenUtil
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();

        // Valida el token
        boolean isValid = jwtTokenUtil.validateToken(token, userDetails);

        // Verifica si el token es válido
        assertTrue(isValid, "El token JWT debería ser válido para el usuario 'paulozzq1'");
    }
}
