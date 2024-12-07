package com.tcshop.tcshopspring.modelo.entidades;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "detalles_pedido")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalle;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @NotNull
    @Column(name = "cantidad")
    private Integer cantidad;

    @NotNull
    @Column(name = "precio")
    private Double precio;

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public @NotNull Pedido getPedido() {
        return pedido;
    }

    public void setPedido(@NotNull Pedido pedido) {
        this.pedido = pedido;
    }

    public @NotNull Producto getProducto() {
        return producto;
    }

    public void setProducto(@NotNull Producto producto) {
        this.producto = producto;
    }

    public @NotNull Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(@NotNull Integer cantidad) {
        this.cantidad = cantidad;
    }

    public @NotNull Double getPrecio() {
        return precio;
    }

    public void setPrecio(@NotNull Double precio) {
        this.precio = precio;
    }
}
