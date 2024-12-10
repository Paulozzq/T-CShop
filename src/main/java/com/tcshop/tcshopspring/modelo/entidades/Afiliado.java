package com.tcshop.tcshopspring.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@Entity
@Table(name = "afiliados_tienda")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Afiliado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAfiliado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tienda_id", nullable = false)
    private Tienda tienda;

    public Afiliado() {
    }

    public Afiliado(Integer idAfiliado, Usuario usuario, Tienda tienda) {
        this.idAfiliado = idAfiliado;
        this.usuario = usuario;
        this.tienda = tienda;
    }

    public Integer getIdAfiliado() {
        return idAfiliado;
    }

    public void setIdAfiliado(Integer idAfiliado) {
        this.idAfiliado = idAfiliado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    @Override
    public String toString() {
        return "Afiliado{" +
                "idAfiliado=" + idAfiliado +
                ", usuario=" + (usuario != null ? usuario.getName() : "No asignado") +
                ", tienda=" + (tienda != null ? tienda.getNombre() : "No asignada") +
                '}';
    }
}
