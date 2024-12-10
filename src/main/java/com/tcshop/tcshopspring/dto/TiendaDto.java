package com.tcshop.tcshopspring.dto;

public class TiendaDto {
    private Integer idTienda;
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private String imagen;
    private String qrImagen;
    private SedeDto sede;
    private UsuarioDto usuario;

    public TiendaDto() {
    }


    public TiendaDto(String nombre, Integer idTienda, String descripcion, String ubicacion, String imagen, String qrImagen, UsuarioDto usuario, SedeDto sede) {
        this.nombre = nombre;
        this.idTienda = idTienda;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.imagen = imagen;
        this.qrImagen = qrImagen;
        this.usuario = usuario;
        this.sede = sede;
    }

    public Integer getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(Integer idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getQrImagen() {
        return qrImagen;
    }

    public void setQrImagen(String qrImagen) {
        this.qrImagen = qrImagen;
    }

    public SedeDto getSede() {
        return sede;
    }

    public void setSede(SedeDto sede) {
        this.sede = sede;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }
}
