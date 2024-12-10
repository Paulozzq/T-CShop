package com.tcshop.tcshopspring.controllers;

import com.tcshop.tcshopspring.Util.JwtTokenUtil;
import com.tcshop.tcshopspring.dto.LoginDto;
import com.tcshop.tcshopspring.dto.UsuarioDto;
import com.tcshop.tcshopspring.modelo.entidades.Usuario;
import com.tcshop.tcshopspring.servicios.LoginServiceImpl;
import com.tcshop.tcshopspring.servicios.RegisterServiceImpl;
import com.tcshop.tcshopspring.servicios.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private RegisterServiceImpl registerService;

    @Autowired
    private LoginServiceImpl loginService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @GetMapping("/test")
    public String testEndpoint() {
        return "Good"; 
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Usuario usuario) {
        if (usuario.getEmail() == null || !usuario.getEmail().endsWith("@tecsup.edu.pe")) {
            return ResponseEntity.badRequest().body("El correo debe pertenecer al dominio @tecsup.edu.pe.");
        }
        registerService.registrarUsuario(usuario);
        return ResponseEntity.ok("Usuario registrado exitosamente. Se ha enviado un correo de verificación.");
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyAccount(@RequestParam String token) {
        Usuario usuario = registerService.verificarToken(token);

        if (usuario != null) {
            usuario.setEnable(true);
            registerService.actualizarUsuario(usuario);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "http://localhost:5173/login")
                    .build();
        } else {
            return ResponseEntity.badRequest().body("Token inválido.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody LoginDto loginDto) {
        String token = loginService.loginUser(loginDto);
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }

    @PostMapping("/user-info")
    public UsuarioDto getUserInfo(@RequestParam String token) {
        // Extraer el username del token
        String username = jwtTokenUtil.extractUsername(token);

        // Buscar al usuario con el username
        Optional<Usuario> usuarioOpt = usuarioServiceImpl.findByUsername(username);

        // Verificar si el usuario fue encontrado
        if (!usuarioOpt.isPresent()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        Usuario usuario = usuarioOpt.get();
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setUsername(usuario.getUsername());
        usuarioDto.setName(usuario.getName());
        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setEnable(usuario.getEnable());
        usuarioDto.setDepartamento(usuario.getDepartamento());
        usuarioDto.setCarrera(usuario.getCarrera());
        usuarioDto.setSede(usuario.getSede());


        return ResponseEntity.ok(usuarioDto).getBody();
    }
}