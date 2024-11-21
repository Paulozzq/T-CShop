package com.tcshop.tcshopspring.controllers;


import com.tcshop.tcshopspring.modelo.entidades.Horario;
import com.tcshop.tcshopspring.modelo.entidades.Tienda;
import com.tcshop.tcshopspring.servicios.HorarioServiceImpl;
import com.tcshop.tcshopspring.servicios.TiendaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tiendas")
public class TiendaController {

    private final TiendaServiceImpl tiendaService;
    private final HorarioServiceImpl horarioServiceImpl;

    @Autowired
    public TiendaController(TiendaServiceImpl tiendaService, HorarioServiceImpl horarioServiceImpl) {
        this.tiendaService = tiendaService;
        this.horarioServiceImpl = horarioServiceImpl;
    }

    @PostMapping
    public ResponseEntity<Tienda> guardarTienda(@RequestBody Tienda tienda) {
        Tienda nuevaTienda = tiendaService.guardarTienda(tienda);
        Horario horarioPorDefecto = new Horario();
        horarioPorDefecto.setApertura(LocalTime.parse("09:00"));
        horarioPorDefecto.setCierre(LocalTime.parse("18:00"));
        LocalTime horaActual = LocalTime.now();
        if (horaActual.isAfter(horarioPorDefecto.getApertura()) && horaActual.isBefore(horarioPorDefecto.getCierre())) {
            horarioPorDefecto.setEstado("abierto");
        } else {
            horarioPorDefecto.setEstado("cerrado");
        }
        horarioPorDefecto.setTienda(nuevaTienda);
        horarioServiceImpl.guardarHorario(horarioPorDefecto);
        return ResponseEntity.ok(nuevaTienda);
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

    @GetMapping
    public List<Tienda> listarTodasLasTiendas() {
        return tiendaService.listarTodasLasTiendas();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTiendaPorId(@PathVariable Integer id) {
        tiendaService.eliminarTiendaPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tienda> actualizarTienda(@PathVariable Integer id, @RequestBody Tienda tienda) {
        try {
            Tienda tiendaActualizada = tiendaService.actualizarTienda(id, tienda);
            return ResponseEntity.ok(tiendaActualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}