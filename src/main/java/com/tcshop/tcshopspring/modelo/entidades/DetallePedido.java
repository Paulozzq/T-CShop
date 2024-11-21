package com.tcshop.tcshopspring.modelo.entidades;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalle;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @NotNull
    @Column(name = "cantidad")
    private Integer cantidad;

    @NotNull
    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @NotNull
    @Column(name = "subtotal")
    private Double subtotal;

    public DetallePedido() {
    }

    public DetallePedido(Integer idDetalle, Pedido pedido, Producto producto, Integer cantidad, Double precioUnitario, Double subtotal) {
        this.idDetalle = idDetalle;
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

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

    public @NotNull Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(@NotNull Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public @NotNull Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(@NotNull Double subtotal) {
        this.subtotal = subtotal;
    }

    private void calcularSubtotal() {
        this.subtotal = this.cantidad * this.precioUnitario;
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                "idDetalle=" + idDetalle +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", subtotal=" + subtotal +
                ", producto=" + producto.getNombre() +
                '}';
    }
}
