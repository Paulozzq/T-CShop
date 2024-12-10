package com.tcshop.tcshopspring.dto;

import java.util.Date;

public class ReviewDto {
    private Integer idReviewProducto;
    private Integer calificacion;
    private String comentario;
    private Date fecha;
    private UsuarioDto usuario;
    private ProductoDto producto;

    public ReviewDto() {
    }

    public Integer getIdReviewProducto() {
        return idReviewProducto;
    }

    public void setIdReviewProducto(Integer idReviewProducto) {
        this.idReviewProducto = idReviewProducto;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    public ProductoDto getProducto() {
        return producto;
    }

    public void setProducto(ProductoDto producto) {
        this.producto = producto;
    }
}
