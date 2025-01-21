package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.TipoFitDance;
import br.com.iouone.service.TipoFitDanceService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/tipo-fit-dance")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
@CrossOrigin
public class TipoFitDanceController {

    @Autowired
    private TipoFitDanceService service;

    @GetMapping
    public List<TipoFitDance> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoFitDance> getById(@PathVariable Integer id) {
        Optional<TipoFitDance> tipoFitDance = service.findById(id);
        return tipoFitDance.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TipoFitDance create(@RequestBody TipoFitDance tipoFitDance) {
        return service.save(tipoFitDance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoFitDance> update(@PathVariable Integer id, @RequestBody TipoFitDance tipoFitDance) {
        tipoFitDance.setId(id); // Set the ID to ensure the update is correct
        TipoFitDance updated = service.save(tipoFitDance);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
