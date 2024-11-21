package com.tcshop.tcshopspring.modelo.entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "review_producto")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReviewProducto;
    @NotNull
    @Max(5)
    @Min(1)
    @Column(name = "calificacion")
    private Integer calificacion;
    @Column(name = "comentario")
    private String comentario;
    @CreationTimestamp
    @Column(name = "fecha", updatable = false)
    private Date fecha;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    public Review() {
    }

    public Review(Integer idReviewProducto, Integer calificacion, String comentario, Date fecha, Usuario usuario, Producto producto) {
        this.idReviewProducto = idReviewProducto;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fecha = fecha;
        this.usuario = usuario;
        this.producto = producto;
    }

    public Integer getIdReviewProducto() {
        return idReviewProducto;
    }

    public void setIdReviewProducto(Integer idReviewProducto) {
        this.idReviewProducto = idReviewProducto;
    }

    public @NotNull @Max(5) @Min(1) Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(@NotNull @Max(5) @Min(1) Integer calificacion) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
