package com.tcshop.tcshopspring.modelo.entidades;

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "name", length = 100)
    private String name;

    @NotNull
    @Column(name = "username", length = 100)
    private String username;

    @NotNull
    @Column(name = "email", length = 100, unique = true)
    private String email;

    @NotNull
    @Column(name = "password", length = 300)
    private String password;

    // Relación con Rol
    @NotNull
    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;

    @NotNull
    @Column(name = "number", length = 10)
    private String number;

    @NotNull
    @Column(name = "register_date")
    private Timestamp registerDate;

    @NotNull
    @Column(name = "token")
    private String token;

    // Campo para habilitar la verificación de correo electrónico
    @NotNull
    @Column(name = "enable")
    private Boolean enable = false; // Valor por defecto

    // Relaciones con otras entidades
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sede_id", nullable = false)
    private Sede sede;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamento_id", nullable = false)
    private Departamento departamento;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrera_id", nullable = false)
    private Carrera carrera;

    public Usuario() {
    }

    public Usuario(Integer id, String name, String username, String email, String password, Rol rol, String number, Timestamp registerDate, String token, Boolean enable, Sede sede, Departamento departamento, Carrera carrera) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.number = number;
        this.registerDate = registerDate;
        this.token = token;
        this.enable = enable;
        this.sede = sede;
        this.departamento = departamento;
        this.carrera = carrera;
    }

    public @NotNull Integer getId() {
        return this.id;
    }

    public void setId(@NotNull Integer id) {
        this.id = id;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    public @NotNull String getUsername() {
        return username;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public @NotNull Rol getRol() {
        return rol;
    }

    public void setRol(@NotNull Rol rol) {
        this.rol = rol;
    }

    public @NotNull String getNumber() {
        return number;
    }

    public void setNumber(@NotNull String number) {
        this.number = number;
    }

    public @NotNull Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(@NotNull Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public @NotNull String getToken() {
        return token;
    }

    public void setToken(@NotNull String token) {
        this.token = token;
    }

    public @NotNull Boolean getEnable() {
        return enable;
    }

    public void setEnable(@NotNull Boolean enable) {
        this.enable = enable;
    }

    public @NotNull Sede getSede() {
        return sede;
    }

    public void setSede(@NotNull Sede sede) {
        this.sede = sede;
    }

    public @NotNull Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(@NotNull Departamento departamento) {
        this.departamento = departamento;
    }

    public @NotNull Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(@NotNull Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rol=" + rol +
                ", number='" + number + '\'' +
                ", registerDate=" + registerDate +
                ", enable=" + enable +
                ", sede=" + sede +
                ", departamento=" + departamento +
                ", carrera=" + carrera +
                ", token=" + token +
                '}';
    }
}
