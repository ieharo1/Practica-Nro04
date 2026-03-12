package com.example.practicanro04.controller;
import com.example.practicanro04.dto.PedidoDto;
import com.example.practicanro04.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService service;
    public PedidoController(PedidoService service) { this.service = service; }
    @GetMapping public List<PedidoDto> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public PedidoDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public PedidoDto create(@RequestBody PedidoDto dto) { return service.create(dto); }
    @PutMapping("/<built-in function id>") public PedidoDto update(@PathVariable Long id, @RequestBody PedidoDto dto) { return service.update(id, dto); }
    @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
