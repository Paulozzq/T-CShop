package com.tcshop.tcshopspring.modelo.entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;
    @NotNull
    @Column(name = "nombre_categoria")
    private String nombreCategoria;
    @NotNull
    @Column(name = "descripcion_categoria")
    private String descripcionCategoria;
    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private Date fechaCreacion;

    public Categoria() {
    }

    public Categoria(Integer idCategoria, String nombreCategoria, String descripcionCategoria, Date fechaCreacion) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public @NotNull String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(@NotNull String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public @NotNull String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(@NotNull String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", nombreCategoria='" + nombreCategoria + '\'' +
                ", descripcionCategoria='" + descripcionCategoria + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
