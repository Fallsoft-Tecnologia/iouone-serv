package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.UnidadeDeMedida;
import br.com.iouone.service.UnidadeDeMedidaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/unidade-de-medida")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
public class UnidadeDeMedidaController {

    @Autowired
    private UnidadeDeMedidaService service;

    @GetMapping
    public List<UnidadeDeMedida> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadeDeMedida> getById(@PathVariable Integer id) {
        Optional<UnidadeDeMedida> unidadeDeMedida = service.findById(id);
        return unidadeDeMedida.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public UnidadeDeMedida create(@RequestBody UnidadeDeMedida unidadeDeMedida) {
        return service.save(unidadeDeMedida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadeDeMedida> update(@PathVariable Integer id, @RequestBody UnidadeDeMedida unidadeDeMedida) {
        unidadeDeMedida.setId(id);
        UnidadeDeMedida updated = service.save(unidadeDeMedida);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
