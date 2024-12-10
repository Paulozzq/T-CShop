package com.tcshop.tcshopspring.modelo.daos;

import com.tcshop.tcshopspring.modelo.entidades.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TiendaRepository extends JpaRepository<Tienda, Integer> {
    Optional<Tienda> findByNombre(String nombre);
}
