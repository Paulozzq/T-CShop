package com.tcshop.tcshopspring.servicios;

import com.tcshop.tcshopspring.modelo.daos.AfiliadoRepository;
import com.tcshop.tcshopspring.modelo.entidades.Afiliado;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AfiliadoServiceImpl implements AfiliadoService {

    private final AfiliadoRepository afiliadoRepository;

    public AfiliadoServiceImpl(AfiliadoRepository afiliadoRepository) {
        this.afiliadoRepository = afiliadoRepository;
    }

    @Override
    public Afiliado guardarAfiliado(Afiliado afiliado) {
        return afiliadoRepository.save(afiliado);
    }

    @Override
    public List<Afiliado> obtenerAfiliadosPorIdTienda(Integer idTienda) {
        return afiliadoRepository.findByTienda_IdTienda(idTienda);
    }

    @Override
    public Optional<Afiliado> obtenerAfiliadoPorId(Integer id) {
        return afiliadoRepository.findById(id);
    }

    @Override
    public void eliminarAfiliado(Integer id) {
        afiliadoRepository.deleteById(id);
    }
}
