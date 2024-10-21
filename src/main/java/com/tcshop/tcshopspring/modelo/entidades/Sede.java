package com.tcshop.tcshopspring.modelo.entidades;

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sedes")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSede;

    @NotNull
    @Column(name = "nombre_sede", length = 100)
    private String nombreSede;

    @NotNull
    @Column(name = "ciudad", length = 200)
    private String ciudad;

    @NotNull
    @Column(name = "direccion", length = 200)
    private String direccion;

    public Sede() {
    }

    public Sede(Integer idSede, String nombreSede, String ciudad, String direccion) {
        this.idSede = idSede;
        this.nombreSede = nombreSede;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    public @NotNull String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(@NotNull String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public @NotNull String getCiudad() {
        return ciudad;
    }

    public void setCiudad(@NotNull String ciudad) {
        this.ciudad = ciudad;
    }

    public @NotNull String getDireccion() {
        return direccion;
    }

    public void setDireccion(@NotNull String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Sede{" +
                "idSede=" + idSede +
                ", nombreSede='" + nombreSede + '\'' +
                ", ubicacionMapa='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
