package com.tcshop.tcshopspring.modelo.entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @CreationTimestamp
    @Column(name = "fecha", updatable = false)
    private Date fecha;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<DetallePedido> detalles;

    @NotNull
    @Column(name = "estado")
    private String estado; // Por ejemplo: "carrito", "pagado"

    @Column(name = "total")
    private Double total;

    public Pedido() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        if (detalles == null || detalles.isEmpty()) {
            return 0.0;
        }
        return detalles.stream().mapToDouble(detalle -> detalle.getPrecio() != null ? detalle.getPrecio() : 0.0).sum();
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double calcularTotal() {
        if (detalles == null || detalles.isEmpty()) {
            return 0.0;
        }
        return detalles.stream()
                .mapToDouble(detalle -> detalle.getCantidad() * detalle.getPrecio())
                .sum();
    }



}
