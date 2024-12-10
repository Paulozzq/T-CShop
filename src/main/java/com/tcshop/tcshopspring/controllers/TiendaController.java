package com.tcshop.tcshopspring.controllers;


import com.tcshop.tcshopspring.dto.SedeDto;
import com.tcshop.tcshopspring.dto.TiendaDto;
import com.tcshop.tcshopspring.modelo.entidades.Horario;
import com.tcshop.tcshopspring.modelo.entidades.Sede;
import com.tcshop.tcshopspring.modelo.entidades.Tienda;
import com.tcshop.tcshopspring.modelo.entidades.Usuario;
import com.tcshop.tcshopspring.servicios.CloudinaryServiceImpl;
import com.tcshop.tcshopspring.servicios.HorarioServiceImpl;
import com.tcshop.tcshopspring.servicios.TiendaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/tiendas")
public class TiendaController {

    private final TiendaServiceImpl tiendaService;
    private final HorarioServiceImpl horarioServiceImpl;
    private final CloudinaryServiceImpl cloudinaryServiceImpl;

    @Autowired
    public TiendaController(TiendaServiceImpl tiendaService, HorarioServiceImpl horarioServiceImpl, CloudinaryServiceImpl cloudinaryServiceImpl) {
        this.tiendaService = tiendaService;
        this.horarioServiceImpl = horarioServiceImpl;
        this.cloudinaryServiceImpl = cloudinaryServiceImpl;
    }


    @PostMapping
    public ResponseEntity<TiendaDto> guardarTienda(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "fileQr", required = false) MultipartFile fileQr,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("ubicacion") String ubicacion,
            @RequestParam("usuarioId") Integer usuarioId,
            @RequestParam("sedeId") Integer sedeId) throws IOException {

        String urlImagen = null;
        if (file != null) {
            Map<String, String> uploadResult = cloudinaryServiceImpl.upload(file);
            urlImagen = uploadResult.get("url");
        }

        String urlImagenQr = null;
        if (fileQr != null) {
            Map<String, String> uploadResult = cloudinaryServiceImpl.upload(fileQr);
            urlImagenQr = uploadResult.get("url");
        }

        Tienda tienda = new Tienda();
        tienda.setNombre(nombre);
        tienda.setDescripcion(descripcion);
        tienda.setUbicacion(ubicacion);
        tienda.setImagen(urlImagen);
        tienda.setQrImagen(urlImagenQr);

        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        tienda.setUsuario(usuario);

        Sede sede = new Sede();
        sede.setIdSede(sedeId);
        tienda.setSede(sede);

        Tienda nuevaTienda = tiendaService.guardarTienda(tienda);

        Horario horarioPorDefecto = new Horario();
        horarioPorDefecto.setApertura(LocalTime.parse("09:00"));
        horarioPorDefecto.setCierre(LocalTime.parse("18:00"));

        if (horarioPorDefecto.getApertura().isAfter(horarioPorDefecto.getCierre())) {
            throw new IllegalArgumentException("La hora de apertura no puede ser posterior a la hora de cierre.");
        }

        LocalTime horaActual = LocalTime.now();

        if (horaActual.isAfter(horarioPorDefecto.getApertura()) && horaActual.isBefore(horarioPorDefecto.getCierre())) {
            horarioPorDefecto.setEstado("abierto");
        } else {
            horarioPorDefecto.setEstado("cerrado");
        }

        horarioPorDefecto.setTienda(nuevaTienda);
        horarioServiceImpl.guardarHorario(horarioPorDefecto);

        // Crear el DTO para devolver
        TiendaDto tiendaDto = new TiendaDto();
        tiendaDto.setIdTienda(nuevaTienda.getIdTienda());
        tiendaDto.setNombre(nuevaTienda.getNombre());
        tiendaDto.setDescripcion(nuevaTienda.getDescripcion());
        tiendaDto.setUbicacion(nuevaTienda.getUbicacion());
        tiendaDto.setImagen(nuevaTienda.getImagen());
        tiendaDto.setQrImagen(nuevaTienda.getQrImagen());

        SedeDto sedeDto = new SedeDto();
        sedeDto.setIdSede(nuevaTienda.getSede().getIdSede());
        tiendaDto.setSede(sedeDto);

        return ResponseEntity.ok(tiendaDto);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Tienda> obtenerTiendaPorId(@PathVariable Integer id) {
        Optional<Tienda> tienda = tiendaService.obtenerTiendaPorId(id);
        return tienda.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Tienda> obtenerTiendaPorNombre(@PathVariable String nombre) {
        Optional<Tienda> tienda = tiendaService.obtenerTiendaPorNombre(nombre);
        return tienda.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/sede/{idSede}")
    public ResponseEntity<List<TiendaDto>> obtenerTiendasPorSede(@PathVariable Integer idSede) {
        List<TiendaDto> tiendas = tiendaService.listarTodasLasTiendas(idSede);
        return ResponseEntity.ok(tiendas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTiendaPorId(@PathVariable Integer id) {
        tiendaService.eliminarTiendaPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TiendaDto> actualizarTienda(
            @PathVariable("id") Integer id,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "fileQr", required = false) MultipartFile fileQr,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("ubicacion") String ubicacion,
            @RequestParam("usuarioId") Integer usuarioId,
            @RequestParam("sedeId") Integer sedeId) throws IOException {

        Tienda tiendaExistente = tiendaService.obtenerTiendaPorId(id)
                .orElseThrow(() -> new RuntimeException("Tienda no encontrada"));

        // Actualizar la imagen principal si se proporciona un archivo
        if (file != null) {
            Map<String, String> uploadResult = cloudinaryServiceImpl.upload(file);
            tiendaExistente.setImagen(uploadResult.get("url"));
        }

        // Actualizar la imagen del código QR si se proporciona un archivo
        if (fileQr != null) {
            Map<String, String> uploadResult = cloudinaryServiceImpl.upload(fileQr);
            tiendaExistente.setQrImagen(uploadResult.get("url"));
        }

        // Actualizar los demás campos
        tiendaExistente.setNombre(nombre);
        tiendaExistente.setDescripcion(descripcion);
        tiendaExistente.setUbicacion(ubicacion);

        // Actualizar el usuario y la sede
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        tiendaExistente.setUsuario(usuario);

        Sede sede = new Sede();
        sede.setIdSede(sedeId);
        tiendaExistente.setSede(sede);

        // Guardar los cambios de la tienda
        Tienda tiendaActualizada = tiendaService.guardarTienda(tiendaExistente);

        // Crear el DTO de respuesta
        TiendaDto tiendaDto = new TiendaDto();
        tiendaDto.setIdTienda(tiendaActualizada.getIdTienda());
        tiendaDto.setNombre(tiendaActualizada.getNombre());
        tiendaDto.setDescripcion(tiendaActualizada.getDescripcion());
        tiendaDto.setUbicacion(tiendaActualizada.getUbicacion());
        tiendaDto.setImagen(tiendaActualizada.getImagen());
        tiendaDto.setQrImagen(tiendaActualizada.getQrImagen());

        SedeDto sedeDto = new SedeDto();
        sedeDto.setIdSede(tiendaActualizada.getSede().getIdSede());
        tiendaDto.setSede(sedeDto);

        return ResponseEntity.ok(tiendaDto);
    }

}