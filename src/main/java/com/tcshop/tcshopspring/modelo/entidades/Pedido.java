package com.tcshop.tcshopspring.modelo.entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;
    @CreationTimestamp
    @Column(name = "fecha_pedido", updatable = false)
    private Date fechaPedido;
    @NotNull
    @Column(name = "estado_pedido")
    private String estadoPedido = "pendiente";
    @NotNull
    @Column(name = "total")
    private double total;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detalles = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(Integer idPedido, String estadoPedido, Date fechaPedido, double total, Usuario usuario, List<DetallePedido> detalles) {
        this.idPedido = idPedido;
        this.estadoPedido = estadoPedido;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.usuario = usuario;
        this.detalles = detalles;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public @NotNull String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(@NotNull String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    @NotNull
    public double getTotal() {
        return total;
    }

    public void setTotal(@NotNull double total) {
        this.total = total;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void agregarDetalle(DetallePedido detalle) {
        detalles.add(detalle);
        detalle.setPedido(this);
        calcularTotal();
    }

    public void eliminarDetalle(DetallePedido detalle) {
        detalles.remove(detalle);
        detalle.setPedido(null);
        calcularTotal();
    }

    public void calcularTotal() {
        this.total = detalles.stream().mapToDouble(DetallePedido::getSubtotal).sum();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", fechaPedido=" + fechaPedido +
                ", estadoPedido='" + estadoPedido + '\'' +
                ", total=" + total +
                ", usuario=" + usuario.getId() +
                '}';
    }

}
