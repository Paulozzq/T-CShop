package com.tcshop.tcshopspring.controllers;

import com.tcshop.tcshopspring.modelo.daos.ImagenRepository;
import com.tcshop.tcshopspring.modelo.entidades.Imagen;
import com.tcshop.tcshopspring.servicios.CloudinaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/imagenes")
public class ImagenController {
    private final CloudinaryServiceImpl cloudinaryService;
    private final ImagenRepository imagenRepositorio;
    private final ImagenRepository imagenRepository;

    @Autowired
    public ImagenController(CloudinaryServiceImpl cloudinaryService, ImagenRepository imagenRepositorio, ImagenRepository imagenRepository) {
        this.cloudinaryService = cloudinaryService;
        this.imagenRepositorio = imagenRepositorio;
        this.imagenRepository = imagenRepository;
    }

    @PostMapping("/subir")
    public ResponseEntity<String> subirImagen(
            @RequestParam("file") MultipartFile file,
            @RequestParam("nombre") String nombre) throws IOException {

        Map<String, String> uploadResult = cloudinaryService.upload(file);
        String urlImagen = uploadResult.get("url");

        Imagen imagen = new Imagen();
        imagen.setNombre(nombre);
        imagen.setUrl(urlImagen);

        imagenRepository.save(imagen);

        String message = "Imagen subida y guardada correctamente. URL: " + urlImagen;

        return ResponseEntity.ok(message); // Retorna el mensaje como texto plano
    }
}
