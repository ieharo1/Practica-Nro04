package com.example.practicanro04.controller;
import com.example.practicanro04.dto.PedidoDetalleDto;
import com.example.practicanro04.service.PedidoDetalleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/pedido_detalles")
public class PedidoDetalleController {
    private final PedidoDetalleService service;
    public PedidoDetalleController(PedidoDetalleService service) { this.service = service; }
    @GetMapping public List<PedidoDetalleDto> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public PedidoDetalleDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public PedidoDetalleDto create(@RequestBody PedidoDetalleDto dto) { return service.create(dto); }
    @PutMapping("/<built-in function id>") public PedidoDetalleDto update(@PathVariable Long id, @RequestBody PedidoDetalleDto dto) { return service.update(id, dto); }
    @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
