package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.modelo.entidades.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    Categoria guardarCategoria(Categoria categoria);
    List<Categoria> obtenerCategorias();
    Optional<Categoria> obtenerCategoriaPorId(Integer id);
    void eliminarCategoria(Integer id);
}
