package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.Musculo;
import br.com.iouone.service.MusculoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/musculos")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
@CrossOrigin
public class MusculoController {

    @Autowired
    private MusculoService service;

    @GetMapping
    public List<Musculo> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musculo> getById(@PathVariable Integer id) {
        Optional<Musculo> musculo = service.findById(id);
        return musculo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Musculo create(@RequestBody Musculo musculo) {
        return service.create(musculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Musculo> update(@PathVariable Integer id, @RequestBody Musculo musculo) {
        Musculo updatedMusculo = service.update(id, musculo);
        if (updatedMusculo != null) {
            return ResponseEntity.ok(updatedMusculo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
