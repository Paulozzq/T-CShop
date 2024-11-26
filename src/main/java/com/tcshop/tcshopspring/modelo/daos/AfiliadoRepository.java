package com.tcshop.tcshopspring.modelo.daos;

import com.tcshop.tcshopspring.modelo.entidades.Afiliado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AfiliadoRepository extends JpaRepository<Afiliado, Integer> {
    List<Afiliado> findByTienda_IdTienda(Integer idTienda);
}
