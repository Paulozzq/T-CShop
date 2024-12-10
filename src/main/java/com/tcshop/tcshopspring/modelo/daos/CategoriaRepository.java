package com.tcshop.tcshopspring.modelo.daos;

import com.tcshop.tcshopspring.modelo.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
