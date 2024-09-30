package br.com.iouone.controller;

import br.com.iouone.entity.ReceitaDetox;
import br.com.iouone.service.ReceitaDetoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/receitas-detox")
public class ReceitaDetoxController {

    @Autowired
    private ReceitaDetoxService service;

    @GetMapping
    public List<ReceitaDetox> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaDetox> getById(@PathVariable Integer id) {
        Optional<ReceitaDetox> receitaDetox = service.findById(id);
        return receitaDetox.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ReceitaDetox create(@RequestBody ReceitaDetox receitaDetox) {
        return service.save(receitaDetox);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceitaDetox> update(@PathVariable Integer id, @RequestBody ReceitaDetox receitaDetox) {
        ReceitaDetox updated = service.findById(id)
                .map(existingReceita -> {
                    receitaDetox.setId(existingReceita.getId());
                    return service.save(receitaDetox);
                })
                .orElse(null);

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
