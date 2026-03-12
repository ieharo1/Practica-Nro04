package com.example.practicanro04.service;
import com.example.practicanro04.dto.ClienteDto;
import com.example.practicanro04.entity.Cliente;
import com.example.practicanro04.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;import java.util.stream.Collectors;
@Service @Transactional
public class ClienteService {
    private final ClienteRepository repository;
    public ClienteService(ClienteRepository repository) { this.repository = repository; }
    public List<ClienteDto> findAll() { return repository.findAll().stream().map(this::toDto).collect(Collectors.toList()); }
    public ClienteDto findById(Long id) { return toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente not found"))); }
    public ClienteDto create(ClienteDto dto) { Cliente entity = toEntity(dto); entity.setId(null); return toDto(repository.save(entity)); }
    public ClienteDto update(Long id, ClienteDto dto) { Cliente entity = toEntity(dto); entity.setId(id); return toDto(repository.save(entity)); }
    public void delete(Long id) { repository.deleteById(id); }
    private Cliente toEntity(ClienteDto dto) { Cliente entity = new Cliente(); entity.setNombre(dto.getNombre());
    entity.setEmail(dto.getEmail());
    entity.setTelefono(dto.getTelefono());
    entity.setDireccion(dto.getDireccion()); return entity; }
    private ClienteDto toDto(Cliente entity) { ClienteDto dto = new ClienteDto(); dto.setId(entity.getId());
    dto.setNombre(entity.getNombre());
    dto.setEmail(entity.getEmail());
    dto.setTelefono(entity.getTelefono());
    dto.setDireccion(entity.getDireccion()); return dto; }
}
