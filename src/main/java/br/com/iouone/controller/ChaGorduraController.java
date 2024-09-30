package br.com.iouone.controller;

import br.com.iouone.entity.ChaGordura;
import br.com.iouone.service.ChaGorduraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/cha-gordura")
public class ChaGorduraController {

    @Autowired
    private ChaGorduraService service;

    @GetMapping
    public List<ChaGordura> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChaGordura> getById(@PathVariable Integer id) {
        Optional<ChaGordura> chaGordura = service.findById(id);
        return chaGordura.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ChaGordura create(@RequestBody ChaGordura chaGordura) {
        return service.create(chaGordura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChaGordura> update(@PathVariable Integer id, @RequestBody ChaGordura chaGordura) {
        ChaGordura updated = service.update(id, chaGordura);
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
