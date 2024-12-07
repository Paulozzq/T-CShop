package com.tcshop.tcshopspring.dto;

import com.tcshop.tcshopspring.modelo.entidades.Categoria;

import javax.validation.constraints.NotNull;

public class ProductoDto {
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String imagen;
    private Categoria categoria;
    private TiendaDto tienda;

    public ProductoDto(Integer idProducto, @NotNull String nombre, @NotNull String descripcion, @NotNull Double precio, @NotNull Integer stock, @NotNull String imagenes, Categoria categoria, TiendaDto tiendaDTO) {

    }

    public ProductoDto() {

    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public TiendaDto getTienda() {
        return tienda;
    }

    public void setTienda(TiendaDto tienda) {
        this.tienda = tienda;
    }
}
