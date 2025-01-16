package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.DiaSemana;
import br.com.iouone.service.DiaSemanaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/dia-semana")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
public class DiaSemanaController {

    @Autowired
    private DiaSemanaService service;

    @GetMapping
    public List<DiaSemana> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiaSemana> getById(@PathVariable Integer id) {
        Optional<DiaSemana> diaSemana = service.findById(id);
        return diaSemana.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DiaSemana create(@RequestBody DiaSemana diaSemana) {
        return service.save(diaSemana);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiaSemana> update(@PathVariable Integer id, @RequestBody DiaSemana diaSemana) {
        diaSemana.setId(id);
        DiaSemana updated = service.save(diaSemana);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
