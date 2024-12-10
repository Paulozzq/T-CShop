package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.modelo.entidades.Afiliado;

import java.util.List;
import java.util.Optional;

public interface AfiliadoService {
    Afiliado guardarAfiliado(Afiliado afiliado);
    List<Afiliado> obtenerAfiliadosPorIdTienda(Integer idTienda);
    Optional<Afiliado> obtenerAfiliadoPorId(Integer id);
    void eliminarAfiliado(Integer id);
}
