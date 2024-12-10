package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.dto.ProductoDto;
import com.tcshop.tcshopspring.dto.TiendaDto;
import com.tcshop.tcshopspring.modelo.daos.ProductoRepository;
import com.tcshop.tcshopspring.modelo.daos.TiendaRepository;
import com.tcshop.tcshopspring.modelo.entidades.Producto;
import com.tcshop.tcshopspring.modelo.entidades.Tienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService{
    private final ProductoRepository productoRepository;
    private final TiendaService tiendaService;
    private final TiendaRepository tiendaRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository, TiendaService tiendaService, TiendaRepository tiendaRepository) {
        this.productoRepository = productoRepository;
        this.tiendaService = tiendaService;
        this.tiendaRepository = tiendaRepository;
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
        return productoRepository.findByTiendaIdTienda(idTienda);
    }

    @Override
    public List<Producto> findByCategoria(Integer idCategoria) {
        return null;
    }

    @Override
    public List<ProductoDto> listarProductosPorSede(Integer idSede) {
        List<TiendaDto> tiendasDto = tiendaService.listarTodasLasTiendas(idSede);

        List<Integer> tiendaIds = tiendasDto.stream()
                .map(TiendaDto::getIdTienda)
                .collect(Collectors.toList());

        List<Producto> productos = tiendaIds.stream()
                .flatMap(tiendaId -> productoRepository.findByTiendaIdTienda(tiendaId).stream())
                .collect(Collectors.toList());

        // Mapear los productos a DTOs
        return productos.stream().map(producto -> {
            ProductoDto productoDto = new ProductoDto();
            productoDto.setIdProducto(producto.getIdProducto());
            productoDto.setNombre(producto.getNombre());
            productoDto.setDescripcion(producto.getDescripcion());
            productoDto.setPrecio(producto.getPrecio());
            productoDto.setStock(producto.getStock());
            productoDto.setImagen(producto.getImagenes());

            Tienda tienda = producto.getTienda();

            Optional<Tienda> tiendaOptional = tiendaRepository.findById(producto.getTienda().getIdTienda());
            if (tiendaOptional.isPresent()) {
                tienda = tiendaOptional.get();
            } else {
                tienda = null;
            }

            tienda.setUsuario(null);
            productoDto.setTienda(tienda);

            productoDto.setCategoria(producto.getCategoria());

            return productoDto;
        }).collect(Collectors.toList());
    }
}
