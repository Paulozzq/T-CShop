package com.tcshop.tcshopspring.dto;

public class AfiliadoDto {
    private Integer idAfiliado;
    private UsuarioDto usuario;
    private TiendaDto tienda;

    public AfiliadoDto(Integer idAfiliado, UsuarioDto usuario, TiendaDto tienda) {
        this.idAfiliado = idAfiliado;
        this.usuario = usuario;
        this.tienda = tienda;
    }

    public AfiliadoDto() {
    }

    public TiendaDto getTienda() {
        return tienda;
    }

    public void setTienda(TiendaDto tienda) {
        this.tienda = tienda;
    }

    public Integer getIdAfiliado() {
        return idAfiliado;
    }

    public void setIdAfiliado(Integer idAfiliado) {
        this.idAfiliado = idAfiliado;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }
}
