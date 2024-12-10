package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.dto.ReviewDto;
import com.tcshop.tcshopspring.modelo.entidades.Review;

import java.util.List;

public interface ReviewService {
    Review saveReview(Review review);
    List<ReviewDto> getAllReviews();
    List<ReviewDto> getReviewsByProductoId(Integer productoId);
    List<ReviewDto> getReviewsByUsuarioId(Integer usuarioId);
    void deleteReviewById(Integer id);
}
