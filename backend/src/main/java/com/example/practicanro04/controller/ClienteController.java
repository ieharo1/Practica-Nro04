package com.example.practicanro04.controller;
import com.example.practicanro04.dto.ClienteDto;
import com.example.practicanro04.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService service;
    public ClienteController(ClienteService service) { this.service = service; }
    @GetMapping public List<ClienteDto> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public ClienteDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public ClienteDto create(@RequestBody ClienteDto dto) { return service.create(dto); }
    @PutMapping("/<built-in function id>") public ClienteDto update(@PathVariable Long id, @RequestBody ClienteDto dto) { return service.update(id, dto); }
    @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
