package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.dto.SedeDto;
import com.tcshop.tcshopspring.dto.TiendaAbiertaDto;
import com.tcshop.tcshopspring.modelo.daos.HorarioRepository;
import com.tcshop.tcshopspring.modelo.daos.TiendaRepository;
import com.tcshop.tcshopspring.modelo.entidades.Horario;
import com.tcshop.tcshopspring.modelo.entidades.Tienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<TiendaAbiertaDto> obtenerHorariosAbiertos(Integer idSede) {
        List<Horario> horarios = horarioRepository.findAll();
        LocalTime horaActual = LocalTime.now();
        return horarios.stream()
                .filter(horario -> estaAbierto(horario, horaActual) && horario.getTienda().getSede().getIdSede().equals(idSede))
                .map(horario -> {
                    Tienda tienda = horario.getTienda();
                    TiendaAbiertaDto dto = new TiendaAbiertaDto();

                    dto.setIdHorario(horario.getIdHorario());
                    dto.setApertura(horario.getApertura().toString());
                    dto.setCierre(horario.getCierre().toString());
                    dto.setEstado("Abierto");

                    dto.setIdTienda(tienda.getIdTienda());
                    dto.setNombreTienda(tienda.getNombre());
                    dto.setDescripcion(tienda.getDescripcion());
                    dto.setUbicacion(tienda.getUbicacion());
                    dto.setImagen(tienda.getImagen());
                    dto.setQrImagen(tienda.getQrImagen());

                    SedeDto sedeDto = new SedeDto();
                    sedeDto.setIdSede(tienda.getSede().getIdSede());
                    sedeDto.setNombreSede(tienda.getSede().getNombreSede());
                    sedeDto.setCiudad(tienda.getSede().getCiudad());
                    sedeDto.setDireccion(tienda.getSede().getDireccion());

                    dto.setSede(sedeDto);

                    return dto;
                })
                .collect(Collectors.toList());
    }


    private boolean estaAbierto(Horario horario, LocalTime horaActual) {
        return (horaActual.isAfter(horario.getApertura()) || horaActual.equals(horario.getApertura())) &&
                (horaActual.isBefore(horario.getCierre()) || horaActual.equals(horario.getCierre()));
    }

    @Override
    public Horario buscarHorarioPorIdTienda(Integer idTienda) {
        return horarioRepository.findByTiendaIdTienda(idTienda);
    }
}
