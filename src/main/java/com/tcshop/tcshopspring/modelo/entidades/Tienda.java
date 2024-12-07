package com.tcshop.tcshopspring.modelo.entidades;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="tiendas")
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTienda;
    @NotNull
    @Column(name="nombre_tienda")
    private String nombre;
    @NotNull
    @Column(name="descripcion")
    private String descripcion;
    @NotNull
    @Column(name="ubicacion_mapa")
    private String ubicacion;
    @NotNull
    @Column(name = "imagen")
    private String imagen;
    @NotNull
    @Column(name = "qr_imagen")
    private String qrImagen;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sede_id", nullable = false)
    private Sede sede;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Tienda() {
    }

    public Tienda(Integer idTienda, String nombre, String descripcion, String ubicacion, String  imagen, String qrImagen, Sede sede, Usuario usuario) {
        this.idTienda = idTienda;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.imagen = imagen;
        this.qrImagen = qrImagen;
        this.sede = sede;
        this.usuario = usuario;
    }

    public Integer getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(Integer idTienda) {
        this.idTienda = idTienda;
    }

    public @NotNull String getNombre() {
        return nombre;
    }

    public void setNombre(@NotNull String nombre) {
        this.nombre = nombre;
    }

    public @NotNull String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@NotNull String descripcion) {
        this.descripcion = descripcion;
    }

    public @NotNull String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(@NotNull String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public @NotNull String getImagen() {
        return imagen;
    }

    public void setImagen(@NotNull String imagen) {
        this.imagen = imagen;
    }

    public @NotNull Sede getSede() {
        return sede;
    }

    public void setSede(@NotNull Sede sede) {
        this.sede = sede;
    }

    public @NotNull String getQrImagen() {
        return qrImagen;
    }

    public void setQrImagen(@NotNull String qrImagen) {
        this.qrImagen = qrImagen;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
