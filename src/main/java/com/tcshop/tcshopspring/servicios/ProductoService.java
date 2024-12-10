package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.dto.ProductoDto;
import com.tcshop.tcshopspring.modelo.entidades.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    Producto save(Producto producto);
    Producto update(Integer id, Producto producto);
    void delete(Integer id);
    Optional<Producto> findById(Integer id);
    List<Producto> findAll();
    List<Producto> findByTienda(Integer tiendaId);
    List<Producto> findByCategoria(Integer idCategoria);
    List<ProductoDto> listarProductosPorSede(Integer idSede);
}
