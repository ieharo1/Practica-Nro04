package com.example.practicanro04.controller;
import com.example.practicanro04.dto.PagoDto;
import com.example.practicanro04.service.PagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/pagos")
public class PagoController {
    private final PagoService service;
    public PagoController(PagoService service) { this.service = service; }
    @GetMapping public List<PagoDto> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public PagoDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public PagoDto create(@RequestBody PagoDto dto) { return service.create(dto); }
    @PutMapping("/<built-in function id>") public PagoDto update(@PathVariable Long id, @RequestBody PagoDto dto) { return service.update(id, dto); }
    @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
