package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.dto.SedeDto;
import com.tcshop.tcshopspring.dto.TiendaDto;
import com.tcshop.tcshopspring.modelo.daos.HorarioRepository;
import com.tcshop.tcshopspring.modelo.daos.TiendaRepository;
import com.tcshop.tcshopspring.modelo.entidades.Tienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TiendaServiceImpl implements TiendaService {

    private final TiendaRepository tiendaRepository;
    private final HorarioRepository horarioRepository;

    @Autowired
    public TiendaServiceImpl(TiendaRepository tiendaRepository, HorarioRepository horarioRepository) {
        this.tiendaRepository = tiendaRepository;
        this.horarioRepository = horarioRepository;
    }

    @Override
    public Tienda guardarTienda(Tienda tienda) {
        return tiendaRepository.save(tienda);
    }

    @Override
    public Optional<Tienda> obtenerTiendaPorId(Integer id) {
        return tiendaRepository.findById(id);
    }

    @Override
    public Optional<Tienda> obtenerTiendaPorNombre(String nombre) {
        return tiendaRepository.findByNombre(nombre);
    }

    @Override
    public List<TiendaDto> listarTodasLasTiendas(Integer idSede) {
        List<Tienda> tiendas = tiendaRepository.findAll();

        return tiendas.stream()
                .filter(tienda -> tienda.getSede() != null && tienda.getSede().getIdSede().equals(idSede))
                .map(tienda -> {
                    TiendaDto dto = new TiendaDto();
                    dto.setIdTienda(tienda.getIdTienda());
                    dto.setNombre(tienda.getNombre());
                    dto.setDescripcion(tienda.getDescripcion());
                    dto.setUbicacion(tienda.getUbicacion());
                    dto.setImagen(tienda.getImagen());
                    dto.setQrImagen(tienda.getQrImagen());


                    if (tienda.getSede() != null) {
                        SedeDto sedeDto = new SedeDto();
                        sedeDto.setIdSede(tienda.getSede().getIdSede());
                        sedeDto.setNombreSede(tienda.getSede().getNombreSede());
                        sedeDto.setCiudad(tienda.getSede().getCiudad());
                        sedeDto.setDireccion(tienda.getSede().getDireccion());
                        dto.setSede(sedeDto);
                    }

                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarTiendaPorId(Integer id) {
        tiendaRepository.deleteById(id);
    }

    @Override
    public Tienda actualizarTienda(Integer id, Tienda tienda) {
        Optional<Tienda> tiendaExistente = tiendaRepository.findById(id);
        if (tiendaExistente.isPresent()) {
            Tienda tiendaActualizada = tiendaExistente.get();
            tiendaActualizada.setNombre(tienda.getNombre());
            tiendaActualizada.setDescripcion(tienda.getDescripcion());
            tiendaActualizada.setUbicacion(tienda.getUbicacion());
            tiendaActualizada.setImagen(tienda.getImagen());
            tiendaActualizada.setQrImagen(tienda.getQrImagen());
            tiendaActualizada.setSede(tienda.getSede());
            return tiendaRepository.save(tiendaActualizada);
        } else {
            throw new RuntimeException("Tienda con id " + id + " no encontrada.");
        }
    }
}
