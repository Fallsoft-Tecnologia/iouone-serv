package br.com.iouone.controller;

import br.com.iouone.entity.Ingredientes;
import br.com.iouone.service.IngredientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/ingredientes")
public class IngredientesController {

    @Autowired
    private IngredientesService service;

    @GetMapping
    public List<Ingredientes> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredientes> getById(@PathVariable Integer id) {
        Optional<Ingredientes> ingrediente = service.findById(id);
        return ingrediente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ingredientes create(@RequestBody Ingredientes ingrediente) {
        return service.create(ingrediente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredientes> update(@PathVariable Integer id, @RequestBody Ingredientes ingrediente) {
        Ingredientes updatedIngrediente = service.update(id, ingrediente);
        if (updatedIngrediente != null) {
            return ResponseEntity.ok(updatedIngrediente);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
