package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.modelo.daos.ProductoRepository;
import com.tcshop.tcshopspring.modelo.entidades.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Integer id, Producto producto) {
        Optional<Producto> existingProducto = productoRepository.findById(id);
        if (existingProducto.isPresent()) {
            Producto updatedProducto = existingProducto.get();
            updatedProducto.setNombre(producto.getNombre());
            updatedProducto.setDescripcion(producto.getDescripcion());
            updatedProducto.setPrecio(producto.getPrecio());
            updatedProducto.setStock(producto.getStock());
            updatedProducto.setCategoria(producto.getCategoria());
            updatedProducto.setTienda(producto.getTienda());
            return productoRepository.save(updatedProducto);
        } else {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }
    }

    @Override
    public void delete(Integer id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Optional<Producto> findById(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public List<Producto> findByTienda(Integer idTienda) {
        return null;
    }

    @Override
    public List<Producto> findByCategoria(Integer idCategoria) {
        return null;
    }

}
