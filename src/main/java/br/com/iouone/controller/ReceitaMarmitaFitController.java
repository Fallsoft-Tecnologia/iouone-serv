package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.ReceitaMarmitaFit;
import br.com.iouone.service.ReceitaMarmitaFitService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/receitas-marmita-fit")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
@CrossOrigin
public class ReceitaMarmitaFitController {

    @Autowired
    private ReceitaMarmitaFitService service;

    @GetMapping
    public List<ReceitaMarmitaFit> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaMarmitaFit> getById(@PathVariable Integer id) {
        Optional<ReceitaMarmitaFit> receitaMarmitaFit = service.findById(id);
        return receitaMarmitaFit.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ReceitaMarmitaFit create(@RequestBody ReceitaMarmitaFit receitaMarmitaFit) {
        return service.save(receitaMarmitaFit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceitaMarmitaFit> update(@PathVariable Integer id, @RequestBody ReceitaMarmitaFit receitaMarmitaFit) {
        ReceitaMarmitaFit updated = service.findById(id)
                .map(existingReceita -> {
                    receitaMarmitaFit.setId(existingReceita.getId());
                    return service.save(receitaMarmitaFit);
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
