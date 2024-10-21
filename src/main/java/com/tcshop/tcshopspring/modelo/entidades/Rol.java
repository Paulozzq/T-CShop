package com.tcshop.tcshopspring.modelo.entidades;

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;

    @NotNull
    @Column(name = "nombre_rol", length = 50)
    private String nombreRol;

    public Rol() {
    }

    public Rol(Integer idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public @NotNull String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(@NotNull String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + idRol +
                ", nombreRol='" + nombreRol + '\'' +
                '}';
    }
}

