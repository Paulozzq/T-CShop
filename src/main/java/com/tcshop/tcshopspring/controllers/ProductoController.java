package com.tcshop.tcshopspring.controllers;

import com.stripe.model.Charge;
import com.tcshop.tcshopspring.dto.ProductoDto;
import com.tcshop.tcshopspring.modelo.daos.CategoriaRepository;
import com.tcshop.tcshopspring.modelo.daos.ProductoRepository;
import com.tcshop.tcshopspring.modelo.daos.TiendaRepository;
import com.tcshop.tcshopspring.modelo.entidades.Categoria;
import com.tcshop.tcshopspring.modelo.entidades.Producto;
import com.tcshop.tcshopspring.modelo.entidades.Tienda;
import com.tcshop.tcshopspring.servicios.CloudinaryServiceImpl;
import com.tcshop.tcshopspring.servicios.ProductoService;
import com.tcshop.tcshopspring.stripe.StripeClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;
    private final StripeClient stripeClient;
    private final CategoriaRepository categoriaRepository;
    private final TiendaRepository tiendaRepository;
    private final ProductoRepository productoRepository;
    private final CloudinaryServiceImpl cloudinaryServiceImpl;

    public ProductoController(ProductoService productoService, StripeClient stripeClient, CategoriaRepository categoriaRepository, TiendaRepository tiendaRepository, ProductoRepository productoRepository, CloudinaryServiceImpl cloudinaryServiceImpl) {
        this.productoService = productoService;
        this.stripeClient = stripeClient;
        this.categoriaRepository = categoriaRepository;
        this.tiendaRepository = tiendaRepository;
        this.productoRepository = productoRepository;
        this.cloudinaryServiceImpl = cloudinaryServiceImpl;
    }

    @PostMapping
    public ResponseEntity<ProductoDto> crear(
            @RequestParam("file") MultipartFile file,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("precio") Double precio,
            @RequestParam("stock") Integer stock,
            @RequestParam("categoriaId") Integer categoriaId,
            @RequestParam("tiendaId") Integer tiendaId) throws IOException {

        Map<String, String> uploadResult = cloudinaryServiceImpl.upload(file);
        String urlImagen = uploadResult.get("url");

        Categoria categoria = categoriaRepository.findById(categoriaId).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        Optional<Tienda> optionalTienda = tiendaRepository.findById(tiendaId);
        Tienda tienda = optionalTienda.orElseThrow(() -> new RuntimeException("Tienda no encontrada"));

        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setCategoria(categoria);
        producto.setTienda(tienda);
        producto.setImagenes(urlImagen);

        productoRepository.save(producto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> actualizarProducto(
            @PathVariable Integer id,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("precio") Double precio,
            @RequestParam("stock") Integer stock,
            @RequestParam("categoriaId") Integer categoriaId,
            @RequestParam("tiendaId") Integer tiendaId) throws IOException {

        Producto productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        if (file != null) {
            Map<String, String> uploadResult = cloudinaryServiceImpl.upload(file);
            String urlImagen = uploadResult.get("url");
            productoExistente.setImagenes(urlImagen);
        }

        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        Tienda tienda = tiendaRepository.findById(tiendaId)
                .orElseThrow(() -> new RuntimeException("Tienda no encontrada"));

        productoExistente.setIdProducto(id);
        productoExistente.setNombre(nombre);
        productoExistente.setDescripcion(descripcion);
        productoExistente.setPrecio(precio);
        productoExistente.setStock(stock);
        productoExistente.setCategoria(categoria);
        productoExistente.setTienda(tienda);

        productoRepository.save(productoExistente);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Integer id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
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

            Tienda tiendaDto = new Tienda();
            tiendaDto.setIdTienda(producto.getTienda().getIdTienda());
            tiendaDto.setNombre(producto.getTienda().getNombre());
            tiendaDto.setDescripcion(producto.getTienda().getDescripcion());
            tiendaDto.setUbicacion(producto.getTienda().getUbicacion());
            tiendaDto.setImagen(producto.getTienda().getImagen());
            tiendaDto.setQrImagen(producto.getTienda().getQrImagen());

            productoDto.setTienda(tiendaDto);


            Categoria categoria = producto.getCategoria();
            productoDto.setCategoria(categoria);

            return productoDto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(productoDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> getProductoById(@PathVariable Integer id) {
        Optional<Producto> productoOptional = productoService.findById(id);

        if (!productoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Producto producto = productoOptional.get();
        ProductoDto productoDto = new ProductoDto();
        productoDto.setIdProducto(producto.getIdProducto());
        productoDto.setNombre(producto.getNombre());
        productoDto.setDescripcion(producto.getDescripcion());
        productoDto.setPrecio(producto.getPrecio());
        productoDto.setStock(producto.getStock());
        productoDto.setImagen(producto.getImagenes());


        Tienda tiendaDto = new Tienda();
        tiendaDto.setIdTienda(producto.getTienda().getIdTienda());
        tiendaDto.setNombre(producto.getTienda().getNombre());
        tiendaDto.setDescripcion(producto.getTienda().getDescripcion());
        tiendaDto.setUbicacion(producto.getTienda().getUbicacion());
        tiendaDto.setImagen(producto.getTienda().getImagen());
        tiendaDto.setQrImagen(producto.getTienda().getQrImagen());

        productoDto.setTienda(tiendaDto);

        Categoria categoria = producto.getCategoria();
        productoDto.setCategoria(categoria);

        return ResponseEntity.ok(productoDto);
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
