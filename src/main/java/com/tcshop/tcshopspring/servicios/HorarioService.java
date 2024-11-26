package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.dto.TiendaAbiertaDto;
import com.tcshop.tcshopspring.modelo.entidades.Horario;

import java.util.List;
import java.util.Optional;

public interface HorarioService {
    List<TiendaAbiertaDto> obtenerHorariosAbiertos(Integer idSede);
    Optional<Horario> obtenerHorarioPorId(Integer id);
    Horario guardarHorario(Horario horario);
    Horario actualizarHorario(Integer id, Horario horario);
}
