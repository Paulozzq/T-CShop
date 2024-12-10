package com.tcshop.tcshopspring.controllers;

import com.stripe.model.Charge;
import com.tcshop.tcshopspring.dto.*;
import com.tcshop.tcshopspring.modelo.entidades.*;
import com.tcshop.tcshopspring.servicios.DetallePedidoService;
import com.tcshop.tcshopspring.servicios.PedidoService;
import com.tcshop.tcshopspring.servicios.ProductoService;
import com.tcshop.tcshopspring.servicios.UsuarioService;
import com.tcshop.tcshopspring.stripe.StripeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;
    private final ProductoService productoService;
    private final DetallePedidoService detallePedidoService;
    private final UsuarioService usuarioService;
    private final StripeClient stripeClient;

    @Autowired
    public PedidoController(PedidoService pedidoService, ProductoService productoService,
                            DetallePedidoService detallePedidoService, UsuarioService usuarioService, StripeClient stripeClient) {
        this.pedidoService = pedidoService;
        this.productoService = productoService;
        this.detallePedidoService = detallePedidoService;
        this.usuarioService = usuarioService;
        this.stripeClient = stripeClient;
    }

    @PostMapping
    public ResponseEntity<PedidoDto> crearPedido(@RequestBody Map<String, Integer> request) {
        Integer idUsuario = request.get("id");

        Optional<Usuario> usuarioOptional = usuarioService.findById(idUsuario);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();

            Pedido nuevoPedido = new Pedido();
            nuevoPedido.setUsuario(usuario);
            nuevoPedido.setEstado("carrito");

            Pedido pedidoGuardado = pedidoService.save(nuevoPedido);

            PedidoDto pedidoDto = new PedidoDto();
            pedidoDto.setIdPedido(pedidoGuardado.getIdPedido());

            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(usuario.getId());
            usuarioDto.setName(usuario.getName());
            usuarioDto.setEmail(usuario.getEmail());
            pedidoDto.setUsuario(usuarioDto);

            pedidoDto.setFecha(pedidoGuardado.getFecha());
            pedidoDto.setEstado(pedidoGuardado.getEstado());
            pedidoDto.setTotal(pedidoGuardado.getTotal());

            return new ResponseEntity<>(pedidoDto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<PedidoDto> verCarrito(@PathVariable Integer idPedido) {
        Optional<Pedido> pedidoOptional = pedidoService.findById(idPedido);

        if (pedidoOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Pedido pedido = pedidoOptional.get();
        PedidoDto pedidoDto = new PedidoDto();
        pedidoDto.setIdPedido(pedido.getIdPedido());
        pedidoDto.setFecha(pedido.getFecha());
        pedidoDto.setEstado(pedido.getEstado());
        pedidoDto.setTotal(pedido.getTotal());

        if (pedido.getUsuario() != null) {
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(pedido.getUsuario().getId());
            usuarioDto.setName(pedido.getUsuario().getName());
            usuarioDto.setEmail(pedido.getUsuario().getEmail());
            pedidoDto.setUsuario(usuarioDto);
        }

        List<DetallePedidoDto> detallesDto = (pedido.getDetalles() != null ?
                pedido.getDetalles().stream().map(detalle -> {
                    DetallePedidoDto detalleDto = new DetallePedidoDto();

                    if (detalle.getProducto() != null) {
                        ProductoDto productoDto = new ProductoDto();
                        productoDto.setIdProducto(detalle.getProducto().getIdProducto());
                        productoDto.setNombre(detalle.getProducto().getNombre());
                        productoDto.setDescripcion(detalle.getProducto().getDescripcion());
                        productoDto.setPrecio(detalle.getProducto().getPrecio());
                        productoDto.setStock(detalle.getProducto().getStock());
                        productoDto.setImagen(detalle.getProducto().getImagenes());
                        productoDto.setCategoria(detalle.getProducto().getCategoria());

                        Tienda tiendaDto = new Tienda();
                        tiendaDto.setIdTienda(detalle.getProducto().getTienda().getIdTienda());
                        tiendaDto.setNombre(detalle.getProducto().getTienda().getNombre());

                        productoDto.setTienda(tiendaDto);

                        detalleDto.setProducto(productoDto);
                    }


                    detalleDto.setIdDetalle(detalle.getIdDetalle());
                    detalleDto.setCantidad(detalle.getCantidad());
                    detalleDto.setSubtotal(detalle.getPrecio());

                    return detalleDto;
                }).collect(Collectors.toList()) : new ArrayList<>());

        pedidoDto.setDetalles(detallesDto);

        return new ResponseEntity<>(pedidoDto, HttpStatus.OK);
    }


    @PostMapping("/{idPedido}/add")
    public ResponseEntity<String> agregarProductoAlCarrito(@PathVariable Integer idPedido,
                                                           @RequestBody DetallePedidoDto detallePedidoDto) {
        Optional<Pedido> pedidoOptional = pedidoService.findById(idPedido);
        if (pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();

            Integer idProducto = detallePedidoDto.getProducto().getIdProducto();
            Integer cantidad = detallePedidoDto.getCantidad();

            Optional<Producto> productoOptional = productoService.findById(idProducto);
            if (productoOptional.isPresent()) {
                Producto producto = productoOptional.get();

                if (producto.getStock() < cantidad) {
                    return new ResponseEntity<>("Stock insuficiente para el producto", HttpStatus.BAD_REQUEST);
                }

                DetallePedido detallePedido = new DetallePedido();
                detallePedido.setPedido(pedido);
                detallePedido.setProducto(producto);
                detallePedido.setCantidad(cantidad);
                detallePedidoDto.setSubtotal(producto.getPrecio());
                detallePedido.setPrecio(detallePedidoDto.getSubtotal());

                detallePedidoService.saveDetalle(detallePedido);

                producto.setStock(producto.getStock() - cantidad);
                productoService.save(producto);

                pedido.setTotal(pedido.getTotal() + detallePedido.getPrecio());
                pedidoService.save(pedido);

                return new ResponseEntity<>("Producto agregado al carrito", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Pedido no encontrado", HttpStatus.NOT_FOUND);
        }
    }



    @PostMapping("/{idPedido}/pagar")
    public ResponseEntity<String> pagarCarrito(@PathVariable Integer idPedido,
                                               @RequestBody Map<String, Object> payload) {
        Optional<Pedido> pedidoOptional = pedidoService.findById(idPedido);
        if (pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();

            String token = (String) payload.get("stripeToken");
            double totalAmount = pedido.getTotal();

            try {
                Charge charge = stripeClient.chargeNewCard(token, (int) (totalAmount));
                pedido.setEstado("pagado");
                pedidoService.save(pedido);

                return new ResponseEntity<>("Pago procesado y pedido confirmado", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Pedido no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
