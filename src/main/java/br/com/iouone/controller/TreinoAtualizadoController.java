package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.TreinoAtualizado;
import br.com.iouone.service.TreinoAtualizadoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/treino-atualizado")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
public class TreinoAtualizadoController {

    @Autowired
    private TreinoAtualizadoService service;

    @GetMapping
    public List<TreinoAtualizado> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreinoAtualizado> getById(@PathVariable Integer id) {
        Optional<TreinoAtualizado> treinoAtualizado = service.findById(id);
        return treinoAtualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TreinoAtualizado create(@RequestBody TreinoAtualizado treinoAtualizado) {
        return service.save(treinoAtualizado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreinoAtualizado> update(@PathVariable Integer id, @RequestBody TreinoAtualizado treinoAtualizado) {
        treinoAtualizado.setId(id);
        TreinoAtualizado updated = service.save(treinoAtualizado);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
