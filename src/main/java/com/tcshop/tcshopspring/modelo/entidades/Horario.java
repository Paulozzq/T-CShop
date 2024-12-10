package com.tcshop.tcshopspring.modelo.entidades;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Entity
@Table(name = "horarios_tienda")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHorario;
    @NotNull
    @Column(name = "hora_apertura")
    private LocalTime apertura;
    @NotNull
    @Column(name = "hora_cierre")
    private LocalTime cierre;
    @NotNull
    @Column(name = "estado")
    private String estado = "cerrado";
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "tienda_id", nullable = false)
    private Tienda tienda;

    public Horario(Integer idHorario, String estado, LocalTime cierre, LocalTime apertura, Tienda tienda) {
        this.idHorario = idHorario;
        this.estado = estado;
        this.cierre = cierre;
        this.apertura = apertura;
        this.tienda = tienda;
    }

    public Horario() {

    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public @NotNull LocalTime getCierre() {
        return cierre;
    }

    public void setCierre(@NotNull LocalTime cierre) {
        this.cierre = cierre;
    }

    public @NotNull LocalTime getApertura() {
        return apertura;
    }

    public void setApertura(@NotNull LocalTime apertura) {
        this.apertura = apertura;
    }

    public @NotNull String getEstado() {
        return estado;
    }

    public void setEstado(@NotNull String estado) {
        this.estado = estado;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "idHorario=" + idHorario +
                ", horaApertura='" + apertura + '\'' +
                ", horaCierre='" + cierre + '\'' +
                ", estado='" + estado + '\'' +
                ", tienda=" + (tienda != null ? tienda.getNombre() : "No asignada") +
                '}';
    }
}
