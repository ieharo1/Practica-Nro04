package com.example.practicanro04.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pedido_detalle")
public class PedidoDetalle {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private Long pedidoId;
private Long productoId;
private Integer cantidad;
private BigDecimal precioUnitario;
private BigDecimal subtotal;

    public Long getId() { return id; }
public void setId(Long id) { this.id = id; }

public Long getPedidoId() { return pedidoId; }
public void setPedidoId(Long pedidoId) { this.pedidoId = pedidoId; }

public Long getProductoId() { return productoId; }
public void setProductoId(Long productoId) { this.productoId = productoId; }

public Integer getCantidad() { return cantidad; }
public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

public BigDecimal getPrecioUnitario() { return precioUnitario; }
public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }

public BigDecimal getSubtotal() { return subtotal; }
public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
}
