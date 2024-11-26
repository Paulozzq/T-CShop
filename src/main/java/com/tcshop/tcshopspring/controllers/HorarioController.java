package com.tcshop.tcshopspring.controllers;

import com.tcshop.tcshopspring.dto.TiendaAbiertaDto;
import com.tcshop.tcshopspring.modelo.entidades.Horario;
import com.tcshop.tcshopspring.servicios.HorarioServiceImpl;
import com.tcshop.tcshopspring.servicios.TiendaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Horario> getHorario(@PathVariable Integer id) {
        Optional<Horario> horarios = horarioServiceImpl.obtenerHorarioPorId(id);
        return horarios.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity <Horario> actualizarHorario(@PathVariable Integer id, @RequestBody Horario horario) {
        Horario  horarioActualizado = horarioServiceImpl.actualizarHorario(id, horario);
        return ResponseEntity.ok(horarioActualizado);
    }

    @GetMapping("/abiertos/{idSede}")
    public ResponseEntity<List<TiendaAbiertaDto>> obtenerHorariosAbiertosPorSede(@PathVariable("idSede") Integer idSede) {
        List<TiendaAbiertaDto> horariosAbiertos = horarioServiceImpl.obtenerHorariosAbiertos(idSede);
        return ResponseEntity.ok(horariosAbiertos);
    }
}
