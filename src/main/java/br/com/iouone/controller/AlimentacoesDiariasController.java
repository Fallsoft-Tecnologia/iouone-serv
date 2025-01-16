package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.AlimentacoesDiarias;
import br.com.iouone.service.AlimentacoesDiariasService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/alimentacoes-diarias")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
public class AlimentacoesDiariasController {

    @Autowired
    private AlimentacoesDiariasService service;

    @GetMapping
    public List<AlimentacoesDiarias> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlimentacoesDiarias> getById(@PathVariable Integer id) {
        Optional<AlimentacoesDiarias> alimentacoesDiarias = service.findById(id);
        return alimentacoesDiarias.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public AlimentacoesDiarias create(@RequestBody AlimentacoesDiarias alimentacoesDiarias) {
        return service.create(alimentacoesDiarias);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlimentacoesDiarias> update(@PathVariable Integer id, @RequestBody AlimentacoesDiarias alimentacoesDiarias) {
        AlimentacoesDiarias updated = service.update(id, alimentacoesDiarias);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
