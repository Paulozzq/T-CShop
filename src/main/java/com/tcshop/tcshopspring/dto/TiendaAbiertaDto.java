package com.tcshop.tcshopspring.dto;

import javax.validation.constraints.NotNull;

public class TiendaAbiertaDto {
    private Integer idHorario;
    private String apertura;
    private String cierre;
    private String estado;

    private Integer idTienda;
    private String nombreTienda;
    private String descripcion;
    private String ubicacion;
    private String imagen;
    private String qrImagen;

    @NotNull
    private SedeDto sede;

    public TiendaAbiertaDto() {
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public String getApertura() {
        return apertura;
    }

    public void setApertura(String apertura) {
        this.apertura = apertura;
    }

    public String getCierre() {
        return cierre;
    }

    public void setCierre(String cierre) {
        this.cierre = cierre;
    }

    public Integer getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(Integer idTienda) {
        this.idTienda = idTienda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
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

    public @NotNull SedeDto getSede() {
        return sede;
    }

    public void setSede(@NotNull SedeDto sede) {
        this.sede = sede;
    }
}
