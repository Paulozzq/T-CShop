package com.tcshop.tcshopspring.modelo.daos;

import com.tcshop.tcshopspring.modelo.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByTiendaIdTienda(Integer idTienda);
}