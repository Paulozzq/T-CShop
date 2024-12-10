package com.tcshop.tcshopspring.controllers;

import com.tcshop.tcshopspring.dto.HorarioDto;
import com.tcshop.tcshopspring.dto.TiendaAbiertaDto;
import com.tcshop.tcshopspring.dto.TiendaDto;
import com.tcshop.tcshopspring.modelo.entidades.Horario;
import com.tcshop.tcshopspring.modelo.entidades.Tienda;
import com.tcshop.tcshopspring.servicios.HorarioServiceImpl;
import com.tcshop.tcshopspring.servicios.TiendaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("api/horarios")
public class HorarioController {

    private final HorarioServiceImpl horarioServiceImpl;
    private final TiendaServiceImpl tiendaServiceImpl;

    @Autowired
    public HorarioController(HorarioServiceImpl horarioServiceImpl, TiendaServiceImpl tiendaServiceImpl) {
        this.horarioServiceImpl = horarioServiceImpl;
        this.tiendaServiceImpl = tiendaServiceImpl;
    }

    // Obtener horario por id
    @GetMapping("/{id}")
    public ResponseEntity<HorarioDto> getHorario(@PathVariable Integer id) {
        Optional<Horario> horarios = horarioServiceImpl.obtenerHorarioPorId(id);
        if (horarios.isPresent()) {
            HorarioDto horarioDto = convertirAHorarioDto(horarios.get());
            return ResponseEntity.ok(horarioDto);
        }
        return ResponseEntity.notFound().build();
    }

    // Actualizar horario
    @PutMapping("/{id}")
    public ResponseEntity<HorarioDto> actualizarHorario(@PathVariable Integer id, @RequestBody HorarioDto horarioDto) {
        Horario horario = convertirAHorario(horarioDto);
        Horario horarioActualizado = horarioServiceImpl.actualizarHorario(id, horario);
        HorarioDto horarioDtoActualizado = convertirAHorarioDto(horarioActualizado);
        return ResponseEntity.ok(horarioDtoActualizado);
    }

    // Obtener horarios abiertos por sede
    @GetMapping("/abiertos/{idSede}")
    public ResponseEntity<List<TiendaAbiertaDto>> obtenerHorariosAbiertosPorSede(@PathVariable("idSede") Integer idSede) {
        List<TiendaAbiertaDto> horariosAbiertos = horarioServiceImpl.obtenerHorariosAbiertos(idSede);
        return ResponseEntity.ok(horariosAbiertos);
    }

    // Método auxiliar para convertir Horario a HorarioDto
    private HorarioDto convertirAHorarioDto(Horario horario) {
        HorarioDto horarioDto = new HorarioDto();
        horarioDto.setIdHorario(horario.getIdHorario());
        horarioDto.setApertura(horario.getApertura());
        horarioDto.setCierre(horario.getCierre());
        horarioDto.setEstado(horario.getEstado());

        // Convertir Tienda a TiendaDto
        TiendaDto tiendaDto = new TiendaDto();
        Tienda tienda = horario.getTienda();
        tiendaDto.setIdTienda(tienda.getIdTienda());
        tiendaDto.setNombre(tienda.getNombre());
        tiendaDto.setDescripcion(tienda.getDescripcion());
        tiendaDto.setUbicacion(tienda.getUbicacion());
        tiendaDto.setImagen(tienda.getImagen());

        horarioDto.setTienda(tiendaDto);

        return horarioDto;
    }

    // Método auxiliar para convertir HorarioDto a Horario
    private Horario convertirAHorario(HorarioDto horarioDto) {
        Horario horario = new Horario();
        horario.setIdHorario(horarioDto.getIdHorario());
        horario.setApertura(horarioDto.getApertura());
        horario.setCierre(horarioDto.getCierre());
        horario.setEstado(horarioDto.getEstado());

        // Convertir TiendaDto a Tienda
        Tienda tienda = new Tienda();
        tienda.setIdTienda(horarioDto.getTienda().getIdTienda());
        horario.setTienda(tienda);

        return horario;
    }

    @GetMapping("/tienda/{idTienda}")
    public ResponseEntity<Object> obtenerHorarioPorIdTienda(@PathVariable Integer idTienda) {
        Horario horario = horarioServiceImpl.buscarHorarioPorIdTienda(idTienda);
        Tienda tienda = horario.getTienda();
        if (horario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if (tienda != null) {
            Tienda tiendadto = new Tienda();
            tiendadto.setIdTienda(tienda.getIdTienda());
            tiendadto.setNombre(tienda.getNombre());
            tiendadto.setDescripcion(tienda.getDescripcion());
            tiendadto.setUbicacion(tienda.getUbicacion());
            tiendadto.setImagen(tienda.getImagen());
            tiendadto.setQrImagen(tienda.getQrImagen());
            tiendadto.setSede(tienda.getSede());
            horario.setTienda(tiendadto);
        }

        LocalTime horaActual = LocalTime.now();

        if (horaActual.isAfter(horario.getApertura()) && horaActual.isBefore(horario.getCierre())) {
            horario.setEstado("abierto");
        } else {
            horario.setEstado("cerrado");
        }

        return ResponseEntity.ok(horario);
    }
}
