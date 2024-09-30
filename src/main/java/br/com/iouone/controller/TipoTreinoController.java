package br.com.iouone.controller;

import br.com.iouone.entity.TipoTreino;
import br.com.iouone.service.TipoTreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/tipo-treino")
public class TipoTreinoController {

    @Autowired
    private TipoTreinoService service;

    @GetMapping
    public List<TipoTreino> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoTreino> getById(@PathVariable Integer id) {
        Optional<TipoTreino> tipoTreino = service.findById(id);
        return tipoTreino.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TipoTreino create(@RequestBody TipoTreino tipoTreino) {
        return service.save(tipoTreino);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoTreino> update(@PathVariable Integer id, @RequestBody TipoTreino tipoTreino) {
        tipoTreino.setId(id);
        TipoTreino updated = service.save(tipoTreino);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
