package com.tcshop.tcshopspring.controllers;

import com.stripe.model.Charge;
import com.tcshop.tcshopspring.dto.ProductoDto;
import com.tcshop.tcshopspring.dto.TiendaDto;
import com.tcshop.tcshopspring.modelo.entidades.Categoria;
import com.tcshop.tcshopspring.modelo.entidades.Producto;
import com.tcshop.tcshopspring.servicios.ProductoService;
import com.tcshop.tcshopspring.stripe.StripeClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;
    private final StripeClient stripeClient;

    public ProductoController(ProductoService productoService, StripeClient stripeClient) {
        this.productoService = productoService;
        this.stripeClient = stripeClient;
    }

    @PostMapping
    public ResponseEntity<ProductoDto> createProducto(@RequestBody Producto producto) {
        // Guardar el nuevo producto
        Producto newProducto = productoService.save(producto);

        // Crear y mapear el ProductoDto
        ProductoDto productoDto = new ProductoDto();
        productoDto.setIdProducto(newProducto.getIdProducto());
        productoDto.setNombre(newProducto.getNombre());
        productoDto.setDescripcion(newProducto.getDescripcion());
        productoDto.setPrecio(newProducto.getPrecio());
        productoDto.setStock(newProducto.getStock());

        // Mapeo de Tienda
        TiendaDto tiendaDto = new TiendaDto();
        tiendaDto.setIdTienda(newProducto.getTienda().getIdTienda());
        tiendaDto.setNombre(newProducto.getTienda().getNombre());
        tiendaDto.setDescripcion(newProducto.getTienda().getDescripcion());
        tiendaDto.setUbicacion(newProducto.getTienda().getUbicacion());
        tiendaDto.setImagen(newProducto.getTienda().getImagen());

        // Establecer Tienda en ProductoDto
        productoDto.setTienda(tiendaDto);

        // Mapeo de Categoria (sin usar CategoriaDto)
        Categoria categoria = newProducto.getCategoria(); // Usamos directamente la entidad Categoria
        productoDto.setCategoria(categoria);

        return ResponseEntity.status(HttpStatus.CREATED).body(productoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        Producto updatedProducto = productoService.update(id, producto);

        ProductoDto productoDto = new ProductoDto();
        productoDto.setIdProducto(updatedProducto.getIdProducto());
        productoDto.setNombre(updatedProducto.getNombre());
        productoDto.setDescripcion(updatedProducto.getDescripcion());
        productoDto.setPrecio(updatedProducto.getPrecio());
        productoDto.setStock(updatedProducto.getStock());

        TiendaDto tiendaDto = new TiendaDto();
        tiendaDto.setIdTienda(updatedProducto.getTienda().getIdTienda());
        tiendaDto.setNombre(updatedProducto.getTienda().getNombre());
        tiendaDto.setDescripcion(updatedProducto.getTienda().getDescripcion());
        tiendaDto.setUbicacion(updatedProducto.getTienda().getUbicacion());
        tiendaDto.setImagen(updatedProducto.getTienda().getImagen());

        productoDto.setTienda(tiendaDto);

        Categoria categoria = updatedProducto.getCategoria(); // Usamos directamente la entidad Categoria
        productoDto.setCategoria(categoria);

        return ResponseEntity.ok(productoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Integer id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> getProductoById(@PathVariable Integer id) {
        Optional<Producto> producto = productoService.findById(id);

        ProductoDto productoDto = new ProductoDto();
        productoDto.setIdProducto(producto.get().getIdProducto());
        productoDto.setNombre(producto.get().getNombre());
        productoDto.setDescripcion(producto.get().getDescripcion());
        productoDto.setPrecio(producto.get().getPrecio());
        productoDto.setStock(producto.get().getStock());
        productoDto.setImagen(producto.get().getImagenes());


        TiendaDto tiendaDto = new TiendaDto();
        tiendaDto.setIdTienda(producto.get().getTienda().getIdTienda());
        tiendaDto.setNombre(producto.get().getTienda().getNombre());
        tiendaDto.setDescripcion(producto.get().getTienda().getDescripcion());
        tiendaDto.setUbicacion(producto.get().getTienda().getUbicacion());
        tiendaDto.setImagen(producto.get().getTienda().getImagen());

        productoDto.setTienda(tiendaDto);
        Categoria categoria = producto.get().getCategoria();
        productoDto.setCategoria(categoria);

        return ResponseEntity.ok(productoDto);
    }

    @GetMapping
    public ResponseEntity<List<ProductoDto>> getAllProductos() {
        List<Producto> productos = productoService.findAll();
        List<ProductoDto> productoDtos = productos.stream().map(producto -> {
            ProductoDto productoDto = new ProductoDto();
            productoDto.setIdProducto(producto.getIdProducto());
            productoDto.setNombre(producto.getNombre());
            productoDto.setDescripcion(producto.getDescripcion());
            productoDto.setPrecio(producto.getPrecio());
            productoDto.setStock(producto.getStock());

            TiendaDto tiendaDto = new TiendaDto();
            tiendaDto.setIdTienda(producto.getTienda().getIdTienda());
            tiendaDto.setNombre(producto.getTienda().getNombre());
            tiendaDto.setDescripcion(producto.getTienda().getDescripcion());
            tiendaDto.setUbicacion(producto.getTienda().getUbicacion());
            tiendaDto.setImagen(producto.getTienda().getImagen());

            productoDto.setTienda(tiendaDto);


            Categoria categoria = producto.getCategoria();
            productoDto.setCategoria(categoria);

            return productoDto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(productoDtos);
    }
    @PostMapping("/pago/{idProducto}")
    public ResponseEntity<String> realizarPago(@PathVariable Integer idProducto, @RequestBody Map<String, Object> payload) {
        Optional<Producto> productoOptional = productoService.findById(idProducto);

        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            Double amountInCents = (producto.getPrecio());
            String token = (String) payload.get("stripeToken");
            try {
                Charge charge = stripeClient.chargeNewCard(token, amountInCents);
                return new ResponseEntity<>(charge.toJson(), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
