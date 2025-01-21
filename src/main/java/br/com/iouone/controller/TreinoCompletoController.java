package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.TreinoCompleto;
import br.com.iouone.service.TreinoCompletoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/treino-completo")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
@CrossOrigin
public class TreinoCompletoController {

    @Autowired
    private TreinoCompletoService service;

    @GetMapping
    public List<TreinoCompleto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreinoCompleto> getById(@PathVariable Integer id) {
        Optional<TreinoCompleto> treinoCompleto = service.findById(id);
        return treinoCompleto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TreinoCompleto create(@RequestBody TreinoCompleto treinoCompleto) {
        return service.save(treinoCompleto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreinoCompleto> update(@PathVariable Integer id, @RequestBody TreinoCompleto treinoCompleto) {
        treinoCompleto.setId(id);
        TreinoCompleto updated = service.save(treinoCompleto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
