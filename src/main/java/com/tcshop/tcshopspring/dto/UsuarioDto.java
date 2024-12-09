package com.tcshop.tcshopspring.dto;

import com.tcshop.tcshopspring.modelo.entidades.Carrera;
import com.tcshop.tcshopspring.modelo.entidades.Departamento;
import com.tcshop.tcshopspring.modelo.entidades.Rol;
import com.tcshop.tcshopspring.modelo.entidades.Sede;

public class UsuarioDto {
    private Integer id;
    private String name;
    private String username;
    private String email;
    private Rol rol;
    private String number;
    private Boolean enable;
    private Sede sede;
    private Departamento departamento;
    private Carrera carrera;

    public UsuarioDto() {
    }

    public UsuarioDto(Integer id, String name, String username, String email, Boolean enable, String number, Rol rol, Sede sede, Departamento departamento, Carrera carrera) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.enable = enable;
        this.number = number;
        this.rol = rol;
        this.sede = sede;
        this.departamento = departamento;
        this.carrera = carrera;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
