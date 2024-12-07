package com.tcshop.tcshopspring.controllers;

import com.tcshop.tcshopspring.dto.ProductoDto;
import com.tcshop.tcshopspring.dto.ReviewDto;
import com.tcshop.tcshopspring.dto.TiendaDto;
import com.tcshop.tcshopspring.dto.UsuarioDto;
import com.tcshop.tcshopspring.modelo.entidades.Producto;
import com.tcshop.tcshopspring.modelo.entidades.Review;
import com.tcshop.tcshopspring.modelo.entidades.Tienda;
import com.tcshop.tcshopspring.servicios.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private static final Logger log = LoggerFactory.getLogger(ReviewController.class);
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ReviewDto> createReview(@RequestBody Review review) {
        Review savedReview = reviewService.saveReview(review);
        ReviewDto reviewDto = mapToReviewDto(savedReview);
        return ResponseEntity.status(201).body(reviewDto);
    }

    @GetMapping
    public ResponseEntity<List<ReviewDto>> getAllReviews() {
        List<ReviewDto> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/producto/{productoId}")
    public ResponseEntity<List<ReviewDto>> getReviewsByProductoId(@PathVariable Integer productoId) {
        List<ReviewDto> reviews = reviewService.getReviewsByProductoId(productoId);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<ReviewDto>> getReviewsByUsuarioId(@PathVariable Integer usuarioId) {
        List<ReviewDto> reviews = reviewService.getReviewsByUsuarioId(usuarioId);
        return ResponseEntity.ok(reviews);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Integer id) {
        reviewService.deleteReviewById(id);
        return ResponseEntity.noContent().build();
    }

    private ReviewDto mapToReviewDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setIdReviewProducto(review.getIdReviewProducto());
        reviewDto.setCalificacion(review.getCalificacion());
        reviewDto.setComentario(review.getComentario());
        reviewDto.setFecha(review.getFecha());

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(review.getUsuario().getId());
        usuarioDto.setName(review.getUsuario().getName());
        usuarioDto.setUsername(review.getUsuario().getUsername());
        usuarioDto.setEmail(review.getUsuario().getEmail());
        reviewDto.setUsuario(usuarioDto);

        Producto producto = review.getProducto();
        ProductoDto productoDto = new ProductoDto();
        productoDto.setIdProducto(producto.getIdProducto());
        productoDto.setNombre(producto.getNombre());
        productoDto.setDescripcion(producto.getDescripcion());
        productoDto.setPrecio(producto.getPrecio());
        productoDto.setStock(producto.getStock());

        Tienda tienda = producto.getTienda();
        TiendaDto tiendaDto = new TiendaDto();
        log.info(String.valueOf(tienda.getIdTienda()));
        tiendaDto.setIdTienda(tienda.getIdTienda());
        tiendaDto.setNombre(tienda.getNombre());
        tiendaDto.setDescripcion(tienda.getDescripcion());
        tiendaDto.setUbicacion(tienda.getUbicacion());
        tiendaDto.setImagen(tienda.getImagen());
        productoDto.setTienda(tiendaDto);

        productoDto.setCategoria(producto.getCategoria());

        reviewDto.setProducto(productoDto);

        return reviewDto;
    }

}
