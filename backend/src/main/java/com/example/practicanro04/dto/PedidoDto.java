package com.example.practicanro04.dto;
    import java.math.BigDecimal;
import java.time.LocalDateTime;

    public class PedidoDto {
            private Long id;
        private Long clienteId;
        private LocalDateTime fecha;
        private String estado;
        private BigDecimal total;

        public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
    }
