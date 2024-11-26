package com.tcshop.tcshopspring.controllers;

import com.tcshop.tcshopspring.dto.AfiliadoDto;
import com.tcshop.tcshopspring.dto.SedeDto;
import com.tcshop.tcshopspring.dto.TiendaDto;
import com.tcshop.tcshopspring.dto.UsuarioDto;
import com.tcshop.tcshopspring.modelo.entidades.Afiliado;
import com.tcshop.tcshopspring.servicios.AfiliadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/afiliados")
public class AfiliadoController {

    private final AfiliadoService afiliadoService;

    public AfiliadoController(AfiliadoService afiliadoService) {
        this.afiliadoService = afiliadoService;
    }

    @PostMapping
    public ResponseEntity<AfiliadoDto> crearAfiliado(@RequestBody Afiliado afiliado) {
        Afiliado nuevoAfiliado = afiliadoService.guardarAfiliado(afiliado);
        AfiliadoDto afiliadoDto = convertirAAfiliadoDto(nuevoAfiliado);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<AfiliadoDto> obtenerAfiliadoPorId(@PathVariable Integer id) {
        Optional<Afiliado> afiliado = afiliadoService.obtenerAfiliadoPorId(id);
        if (afiliado.isPresent()) {
            AfiliadoDto afiliadoDto = convertirAAfiliadoDto(afiliado.get());
            return ResponseEntity.ok(afiliadoDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tienda/{idTienda}")
    public ResponseEntity<List<AfiliadoDto>> obtenerAfiliadosPorTienda(@PathVariable Integer idTienda) {
        List<Afiliado> afiliados = afiliadoService.obtenerAfiliadosPorIdTienda(idTienda);
        List<AfiliadoDto> afiliadosDto = afiliados.stream()
                .map(this::convertirAAfiliadoDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(afiliadosDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAfiliado(@PathVariable Integer id) {
        afiliadoService.eliminarAfiliado(id);
        return ResponseEntity.noContent().build();
    }

    private AfiliadoDto convertirAAfiliadoDto(Afiliado afiliado) {
        AfiliadoDto afiliadoDto = new AfiliadoDto();
        afiliadoDto.setIdAfiliado(afiliado.getIdAfiliado());

        if (afiliado.getTienda() != null) {
            TiendaDto tiendaDto = new TiendaDto();
            tiendaDto.setIdTienda(afiliado.getTienda().getIdTienda());
            tiendaDto.setNombre(afiliado.getTienda().getNombre());
            tiendaDto.setDescripcion(afiliado.getTienda().getDescripcion());
            tiendaDto.setUbicacion(afiliado.getTienda().getUbicacion());
            tiendaDto.setImagen(afiliado.getTienda().getImagen());
            tiendaDto.setQrImagen(afiliado.getTienda().getQrImagen());
            if (afiliado.getTienda().getSede() != null) {
                SedeDto sedeDto = new SedeDto();
                sedeDto.setIdSede(afiliado.getTienda().getSede().getIdSede());
                sedeDto.setNombreSede(afiliado.getTienda().getSede().getNombreSede());
                sedeDto.setCiudad(afiliado.getTienda().getSede().getCiudad());
                sedeDto.setDireccion(afiliado.getTienda().getSede().getDireccion());
                tiendaDto.setSede(sedeDto);
            }
            afiliadoDto.setTienda(tiendaDto);
        }

        if (afiliado.getUsuario() != null) {
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(afiliado.getUsuario().getId());
            usuarioDto.setName(afiliado.getUsuario().getName());
            usuarioDto.setUsername(afiliado.getUsuario().getUsername());
            usuarioDto.setEmail(afiliado.getUsuario().getEmail());
            afiliadoDto.setUsuario(usuarioDto);
        }

        return afiliadoDto;
    }


}