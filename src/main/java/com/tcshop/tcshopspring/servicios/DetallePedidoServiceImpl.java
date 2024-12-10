package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.modelo.daos.DetallePedidoRepository;
import com.tcshop.tcshopspring.modelo.entidades.DetallePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {
    private final DetallePedidoRepository detallePedidoRepository;

    @Autowired
    public DetallePedidoServiceImpl(DetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    @Override
    public DetallePedido saveDetalle(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }
}
