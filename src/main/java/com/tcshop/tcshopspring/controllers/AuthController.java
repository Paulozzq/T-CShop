package com.tcshop.tcshopspring.controllers;

import com.tcshop.tcshopspring.dto.LoginDto;
import com.tcshop.tcshopspring.modelo.entidades.Usuario;
import com.tcshop.tcshopspring.servicios.LoginServiceImpl;
import com.tcshop.tcshopspring.servicios.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private RegisterServiceImpl registerService;

    @Autowired
    private LoginServiceImpl loginService;


    @GetMapping("/test")
    public String testEndpoint() {
        return "Good"; // Mensaje de prueba
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Usuario usuario) {
        registerService.registrarUsuario(usuario);
        return ResponseEntity.ok("Usuario registrado exitosamente. Se ha enviado un correo de verificación.");
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyAccount(@RequestParam String token) {
        Usuario usuario = registerService.verificarToken(token);

        if (usuario != null) {
            usuario.setEnable(true);
            registerService.actualizarUsuario(usuario);
            return ResponseEntity.ok("Cuenta verificada con éxito.");
        } else {
            return ResponseEntity.badRequest().body("Token inválido.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> loginUser(@RequestBody LoginDto loginDto) {
        Usuario usuario = loginService.loginUser(loginDto);
        System.out.println("Email: " + loginDto.getIdentifier());
        return ResponseEntity.ok(usuario);
    }
}