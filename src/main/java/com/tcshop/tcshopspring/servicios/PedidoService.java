package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.modelo.entidades.Pedido;

import java.util.Optional;

public interface PedidoService {
    Pedido save(Pedido pedido);
    Optional<Pedido> findById(Integer id);
}
