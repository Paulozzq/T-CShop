package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.modelo.entidades.Horario;

import java.util.List;
import java.util.Optional;

public interface HorarioService {
    List<Horario> obtenerTodosHorarios();
    Optional<Horario> obtenerHorarioPorId(Integer id);
    Horario guardarHorario(Horario horario);
    void eliminarHorario(Integer id);
    List<Horario> obtenerTiendasAbiertas();
    Horario actualizarHorario(Integer id, Horario horario);
}
