package com.tcshop.tcshopspring.dto;

import java.time.LocalTime;

public class HorarioDto {
    private Integer idHorario;
    private LocalTime apertura;
    private LocalTime cierre;
    private String estado = "cerrado";
    private TiendaDto tienda;

    public HorarioDto() {
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalTime getCierre() {
        return cierre;
    }

    public void setCierre(LocalTime cierre) {
        this.cierre = cierre;
    }

    public LocalTime getApertura() {
        return apertura;
    }

    public void setApertura(LocalTime apertura) {
        this.apertura = apertura;
    }

    public TiendaDto getTienda() {
        return tienda;
    }

    public void setTienda(TiendaDto tienda) {
        this.tienda = tienda;
    }
}
