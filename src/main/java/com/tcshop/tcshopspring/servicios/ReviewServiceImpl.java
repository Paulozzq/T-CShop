package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.dto.ProductoDto;
import com.tcshop.tcshopspring.dto.ReviewDto;
import com.tcshop.tcshopspring.dto.TiendaDto;
import com.tcshop.tcshopspring.dto.UsuarioDto;
import com.tcshop.tcshopspring.modelo.daos.ReviewRepository;
import com.tcshop.tcshopspring.modelo.entidades.Producto;
import com.tcshop.tcshopspring.modelo.entidades.Review;
import com.tcshop.tcshopspring.modelo.entidades.Tienda;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<ReviewDto> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(this::mapToReviewDto).collect(Collectors.toList());
    }

    @Override
    public List<ReviewDto> getReviewsByProductoId(Integer productoId) {
        List<Review> reviews = reviewRepository.findByProductoIdProducto(productoId);
        return reviews.stream().map(this::mapToReviewDto).collect(Collectors.toList());
    }

    @Override
    public List<ReviewDto> getReviewsByUsuarioId(Integer usuarioId) {
        List<Review> reviews = reviewRepository.findByUsuarioId(usuarioId);
        return reviews.stream().map(this::mapToReviewDto).collect(Collectors.toList());
    }

    @Override
    public void deleteReviewById(Integer id) {
        reviewRepository.deleteById(id);
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
        tiendaDto.setIdTienda(tienda.getIdTienda());
        tiendaDto.setNombre(tienda.getNombre());
        tiendaDto.setDescripcion(tienda.getDescripcion());
        tiendaDto.setUbicacion(tienda.getUbicacion());
        tiendaDto.setImagen(tienda.getImagen());

        productoDto.setCategoria(producto.getCategoria());

        reviewDto.setProducto(productoDto);

        return reviewDto;
    }

}
