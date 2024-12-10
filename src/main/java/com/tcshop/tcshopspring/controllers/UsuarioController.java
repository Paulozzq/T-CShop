package com.tcshop.tcshopspring.controllers;

import com.tcshop.tcshopspring.dto.UsuarioDto;
import com.tcshop.tcshopspring.modelo.entidades.Usuario;
import com.tcshop.tcshopspring.servicios.UsuarioService;
import com.tcshop.tcshopspring.servicios.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioServiceImpl usuarioServiceImpl;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, UsuarioServiceImpl usuarioServiceImpl) {
        this.usuarioService = usuarioService;
        this.usuarioServiceImpl = usuarioServiceImpl;
    }

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getAllUsuarios() {
        List<UsuarioDto> usuarios = usuarioService.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(usuarios);
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        return usuario.map(value -> ResponseEntity.ok(convertToDTO(value)))
                .orElse(ResponseEntity.notFound().build());
    }


    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> updateUsuario(@PathVariable Integer id, @RequestBody UsuarioDto usuarioDTO) {
        Optional<Usuario> existingUsuario = usuarioService.findById(id);
        if (existingUsuario.isPresent()) {
            Usuario usuarioToUpdate = existingUsuario.get();
            updateEntityFromDTO(usuarioDTO, usuarioToUpdate);
            Usuario updatedUsuario = usuarioService.save(usuarioToUpdate);
            return ResponseEntity.ok(convertToDTO(updatedUsuario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) {
        if (usuarioService.findById(id).isPresent()) {
            usuarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<UsuarioDto> findByUsername(@RequestParam String username) {
        Optional<Usuario> usuario = usuarioService.findByUsername(username);
        return usuario.map(value -> ResponseEntity.ok(convertToDTO(value)))
                .orElse(ResponseEntity.notFound().build());
    }


    // Métodos auxiliares para conversión
    private UsuarioDto convertToDTO(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setName(usuario.getName());
        usuarioDto.setUsername(usuario.getUsername());
        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setRol(usuario.getRol());
        usuarioDto.setNumber(usuario.getNumber());
        usuarioDto.setEnable(usuario.getEnable());
        usuarioDto.setSede(usuario.getSede());
        usuarioDto.setDepartamento(usuario.getDepartamento());
        usuarioDto.setCarrera(usuario.getCarrera());
        return usuarioDto;
    }

    private Usuario convertToEntity(UsuarioDto usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setName(usuarioDTO.getName());
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setRol(usuarioDTO.getRol());
        usuario.setNumber(usuarioDTO.getNumber());
        usuario.setEnable(usuarioDTO.getEnable());
        usuario.setSede(usuarioDTO.getSede());
        usuario.setDepartamento(usuarioDTO.getDepartamento());
        usuario.setCarrera(usuarioDTO.getCarrera());
        return usuario;
    }

    private void updateEntityFromDTO(UsuarioDto usuarioDTO, Usuario usuario) {
        usuario.setName(usuarioDTO.getName());
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setRol(usuarioDTO.getRol());
        usuario.setNumber(usuarioDTO.getNumber());
        usuario.setEnable(usuarioDTO.getEnable());
        usuario.setSede(usuarioDTO.getSede());
        usuario.setDepartamento(usuarioDTO.getDepartamento());
        usuario.setCarrera(usuarioDTO.getCarrera());
    }
}
