package com.example.practicanro04.service;
import com.example.practicanro04.dto.PedidoDto;
import com.example.practicanro04.entity.Pedido;
import com.example.practicanro04.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;import java.util.stream.Collectors;
@Service @Transactional
public class PedidoService {
    private final PedidoRepository repository;
    public PedidoService(PedidoRepository repository) { this.repository = repository; }
    public List<PedidoDto> findAll() { return repository.findAll().stream().map(this::toDto).collect(Collectors.toList()); }
    public PedidoDto findById(Long id) { return toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Pedido not found"))); }
    public PedidoDto create(PedidoDto dto) { Pedido entity = toEntity(dto); entity.setId(null); return toDto(repository.save(entity)); }
    public PedidoDto update(Long id, PedidoDto dto) { Pedido entity = toEntity(dto); entity.setId(id); return toDto(repository.save(entity)); }
    public void delete(Long id) { repository.deleteById(id); }
    private Pedido toEntity(PedidoDto dto) { Pedido entity = new Pedido(); entity.setClienteId(dto.getClienteId());
    entity.setFecha(dto.getFecha());
    entity.setEstado(dto.getEstado());
    entity.setTotal(dto.getTotal()); return entity; }
    private PedidoDto toDto(Pedido entity) { PedidoDto dto = new PedidoDto(); dto.setId(entity.getId());
    dto.setClienteId(entity.getClienteId());
    dto.setFecha(entity.getFecha());
    dto.setEstado(entity.getEstado());
    dto.setTotal(entity.getTotal()); return dto; }
}
