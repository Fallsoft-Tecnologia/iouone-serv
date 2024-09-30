package br.com.iouone.controller;

import br.com.iouone.entity.DietaDetalhada;
import br.com.iouone.service.DietaDetalhadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/dieta-detalhada")
public class DietaDetalhadaController {

    @Autowired
    private DietaDetalhadaService service;

    @GetMapping
    public List<DietaDetalhada> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DietaDetalhada> getById(@PathVariable Integer id) {
        Optional<DietaDetalhada> dietaDetalhada = service.findById(id);
        return dietaDetalhada.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DietaDetalhada create(@RequestBody DietaDetalhada dietaDetalhada) {
        return service.create(dietaDetalhada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DietaDetalhada> update(@PathVariable Integer id, @RequestBody DietaDetalhada dietaDetalhada) {
        DietaDetalhada updated = service.update(id, dietaDetalhada);
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
