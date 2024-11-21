package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.modelo.daos.HorarioRepository;
import com.tcshop.tcshopspring.modelo.daos.TiendaRepository;
import com.tcshop.tcshopspring.modelo.entidades.Horario;
import com.tcshop.tcshopspring.modelo.entidades.Tienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class HorarioServiceImpl implements HorarioService {

    private HorarioRepository horarioRepository;
    private final TiendaRepository tiendaRepository;

    @Autowired
    public HorarioServiceImpl(HorarioRepository horarioRepository, TiendaRepository tiendaRepository) {
        this.horarioRepository = horarioRepository;
        this.tiendaRepository = tiendaRepository;
    }

    public List<Horario> obtenerTodosHorarios() {
        return horarioRepository.findAll();
    }

    public Optional<Horario> obtenerHorarioPorId(Integer id) {
        return horarioRepository.findById(id);
    }

    public Horario guardarHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    public void eliminarHorario(Integer id) {
        horarioRepository.deleteById(id);
    }

    @Override
    public Horario actualizarHorario(Integer id, Horario horarioActualizado) {
        Optional<Horario> horarioExistente = horarioRepository.findById(id);

        if (horarioExistente.isPresent()) {
            Horario horario = horarioExistente.get();

            horario.setApertura(horarioActualizado.getApertura());
            horario.setCierre(horarioActualizado.getCierre());
            horario.setEstado(horarioActualizado.getEstado());

            if (horarioActualizado.getTienda() != null) {
                Tienda tienda = tiendaRepository.findById(horarioActualizado.getTienda().getIdTienda())
                        .orElseThrow(() -> new RuntimeException("Tienda no encontrada"));
                horario.setTienda(tienda);
            }

            return horarioRepository.save(horario);
        } else {
            throw new RuntimeException("Horario no encontrado con ID: " + id);
        }
    }

    @Override
    public List<Horario> obtenerTiendasAbiertas() {
        LocalTime horaActual = LocalTime.now();
        return horarioRepository.findByAperturaBeforeAndCierreAfter(horaActual, horaActual);
    }
}
