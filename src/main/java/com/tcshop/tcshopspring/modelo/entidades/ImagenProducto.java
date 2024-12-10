package com.tcshop.tcshopspring.modelo.entidades;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "imagenes_productos")
public class ImagenProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idImagenProducto;
    @NotNull
    @Column(name = "url_imagen")
    private String urlImagen;
    @NotNull
    @Column(name = "descripcion_imagen")
    private String descripcion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prodcuto_id", nullable = false)
    private Producto producto;

    public ImagenProducto() {
    }

    public ImagenProducto(Integer idImagenProducto, String urlImagen, String descripcion, Producto producto) {
        this.idImagenProducto = idImagenProducto;
        this.urlImagen = urlImagen;
        this.descripcion = descripcion;
        this.producto = producto;
    }

    public Integer getIdImagenProducto() {
        return idImagenProducto;
    }

    public void setIdImagenProducto(Integer idImagenProducto) {
        this.idImagenProducto = idImagenProducto;
    }

    public @NotNull String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(@NotNull String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public @NotNull String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@NotNull String descripcion) {
        this.descripcion = descripcion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "ImagenProducto{" +
                "idImagenProducto=" + idImagenProducto +
                ", urlImagen='" + urlImagen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", producto=" + (producto != null ? producto.getIdProducto() : null) +
                '}';
    }
}
