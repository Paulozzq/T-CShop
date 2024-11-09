package com.tcshop.tcshopspring.modelo.entidades;

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "carreras")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCarrera;

    @NotNull
    @Column(name = "nombre_carrera", length = 100)
    private String nombreCarrera;

    // Relación con el Departamento
    @ManyToOne
    @JoinColumn(name = "id_departamento", nullable = false)
    private Departamento departamento;

    public Carrera() {
    }

    public Carrera(Integer idCarrera, String nombreCarrera, Departamento departamento) {
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
        this.departamento = departamento;
    }

    public Integer getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    public @NotNull String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(@NotNull String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "idCarrera=" + idCarrera +
                ", nombreCarrera='" + nombreCarrera + '\'' +
                ", departamento=" + departamento.getNombreDepartamento() +
                '}';
    }
}