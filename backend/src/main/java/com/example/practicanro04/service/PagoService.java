package com.example.practicanro04.service;
import com.example.practicanro04.dto.PagoDto;
import com.example.practicanro04.entity.Pago;
import com.example.practicanro04.repository.PagoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;import java.util.stream.Collectors;
@Service @Transactional
public class PagoService {
    private final PagoRepository repository;
    public PagoService(PagoRepository repository) { this.repository = repository; }
    public List<PagoDto> findAll() { return repository.findAll().stream().map(this::toDto).collect(Collectors.toList()); }
    public PagoDto findById(Long id) { return toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Pago not found"))); }
    public PagoDto create(PagoDto dto) { Pago entity = toEntity(dto); entity.setId(null); return toDto(repository.save(entity)); }
    public PagoDto update(Long id, PagoDto dto) { Pago entity = toEntity(dto); entity.setId(id); return toDto(repository.save(entity)); }
    public void delete(Long id) { repository.deleteById(id); }
    private Pago toEntity(PagoDto dto) { Pago entity = new Pago(); entity.setUsuarioId(dto.getUsuarioId());
    entity.setReferenciaId(dto.getReferenciaId());
    entity.setMonto(dto.getMonto());
    entity.setMetodo(dto.getMetodo());
    entity.setFecha(dto.getFecha());
    entity.setEstado(dto.getEstado());
    entity.setReferencia(dto.getReferencia()); return entity; }
    private PagoDto toDto(Pago entity) { PagoDto dto = new PagoDto(); dto.setId(entity.getId());
    dto.setUsuarioId(entity.getUsuarioId());
    dto.setReferenciaId(entity.getReferenciaId());
    dto.setMonto(entity.getMonto());
    dto.setMetodo(entity.getMetodo());
    dto.setFecha(entity.getFecha());
    dto.setEstado(entity.getEstado());
    dto.setReferencia(entity.getReferencia()); return dto; }
}
