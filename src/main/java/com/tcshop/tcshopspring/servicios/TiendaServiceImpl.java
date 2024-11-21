package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.modelo.daos.TiendaRepository;
import com.tcshop.tcshopspring.modelo.entidades.Tienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiendaServiceImpl implements TiendaService {

    private final TiendaRepository tiendaRepository;

    @Autowired
    public TiendaServiceImpl(TiendaRepository tiendaRepository) {
        this.tiendaRepository = tiendaRepository;
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
    public List<Tienda> listarTodasLasTiendas() {
        return tiendaRepository.findAll();
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
