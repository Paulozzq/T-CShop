package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.modelo.daos.DetallePedidoRepository;
import com.tcshop.tcshopspring.modelo.daos.PedidoRepository;
import com.tcshop.tcshopspring.modelo.entidades.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoServiceImpl(PedidoRepository pedidoRepository, DetallePedidoRepository detallePedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
    @Override
    public Pedido save(Pedido pedido) { return pedidoRepository.save(pedido); }
    @Override
    public Optional<Pedido> findById(Integer id) { return pedidoRepository.findById(id); }
}
