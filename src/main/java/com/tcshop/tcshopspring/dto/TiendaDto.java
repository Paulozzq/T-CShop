package com.tcshop.tcshopspring.dto;

public class TiendaDto {
    private Integer idTienda;
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private String imagen;
    private String qrImagen;
    private SedeDto sede;

    public TiendaDto() {
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
}
