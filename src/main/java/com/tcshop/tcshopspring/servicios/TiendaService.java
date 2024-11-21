package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.modelo.entidades.Tienda;

import java.util.List;
import java.util.Optional;

public interface TiendaService {
    Tienda guardarTienda(Tienda tienda);
    Optional<Tienda> obtenerTiendaPorId(Integer id);
    Optional<Tienda> obtenerTiendaPorNombre(String nombre);
    List<Tienda> listarTodasLasTiendas();
    void eliminarTiendaPorId(Integer id);
    Tienda actualizarTienda(Integer id, Tienda tienda);
}
