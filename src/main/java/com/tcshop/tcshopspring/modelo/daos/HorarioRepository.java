package com.tcshop.tcshopspring.modelo.daos;

import com.tcshop.tcshopspring.modelo.entidades.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {
}