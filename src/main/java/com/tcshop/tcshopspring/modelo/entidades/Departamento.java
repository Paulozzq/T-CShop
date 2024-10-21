package com.tcshop.tcshopspring.modelo.entidades;

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepartamento;

    @NotNull
    @Column(name = "nombre_departamento", length = 100)
    private String nombreDepartamento;

    public Departamento() {
    }

    public Departamento(Integer idDepartamento, String nombreDepartamento) {
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public @NotNull String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(@NotNull String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "idDepartamento=" + idDepartamento +
                ", nombreDepartamento='" + nombreDepartamento + '\'' +
                '}';
    }
}