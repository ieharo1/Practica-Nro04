package com.example.practicanro04.service;
import com.example.practicanro04.dto.PedidoDetalleDto;
import com.example.practicanro04.entity.PedidoDetalle;
import com.example.practicanro04.repository.PedidoDetalleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;import java.util.stream.Collectors;
@Service @Transactional
public class PedidoDetalleService {
    private final PedidoDetalleRepository repository;
    public PedidoDetalleService(PedidoDetalleRepository repository) { this.repository = repository; }
    public List<PedidoDetalleDto> findAll() { return repository.findAll().stream().map(this::toDto).collect(Collectors.toList()); }
    public PedidoDetalleDto findById(Long id) { return toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("PedidoDetalle not found"))); }
    public PedidoDetalleDto create(PedidoDetalleDto dto) { PedidoDetalle entity = toEntity(dto); entity.setId(null); return toDto(repository.save(entity)); }
    public PedidoDetalleDto update(Long id, PedidoDetalleDto dto) { PedidoDetalle entity = toEntity(dto); entity.setId(id); return toDto(repository.save(entity)); }
    public void delete(Long id) { repository.deleteById(id); }
    private PedidoDetalle toEntity(PedidoDetalleDto dto) { PedidoDetalle entity = new PedidoDetalle(); entity.setPedidoId(dto.getPedidoId());
    entity.setProductoId(dto.getProductoId());
    entity.setCantidad(dto.getCantidad());
    entity.setPrecioUnitario(dto.getPrecioUnitario());
    entity.setSubtotal(dto.getSubtotal()); return entity; }
    private PedidoDetalleDto toDto(PedidoDetalle entity) { PedidoDetalleDto dto = new PedidoDetalleDto(); dto.setId(entity.getId());
    dto.setPedidoId(entity.getPedidoId());
    dto.setProductoId(entity.getProductoId());
    dto.setCantidad(entity.getCantidad());
    dto.setPrecioUnitario(entity.getPrecioUnitario());
    dto.setSubtotal(entity.getSubtotal()); return dto; }
}
