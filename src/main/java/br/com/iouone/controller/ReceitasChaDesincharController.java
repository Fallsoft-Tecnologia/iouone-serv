package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.ReceitasChaDesinchar;
import br.com.iouone.service.ReceitasChaDesincharService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/receita-cha-desinchar")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
@CrossOrigin
public class ReceitasChaDesincharController {

    @Autowired
    private ReceitasChaDesincharService service;

    @GetMapping
    public List<ReceitasChaDesinchar> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitasChaDesinchar> getById(@PathVariable Integer id) {
        Optional<ReceitasChaDesinchar> receitasChaDesinchar = service.findById(id);
        return receitasChaDesinchar.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ReceitasChaDesinchar create(@RequestBody ReceitasChaDesinchar receitasChaDesinchar) {
        return service.save(receitasChaDesinchar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceitasChaDesinchar> update(@PathVariable Integer id, @RequestBody ReceitasChaDesinchar receitasChaDesinchar) {
        receitasChaDesinchar.setId(id);
        ReceitasChaDesinchar updated = service.save(receitasChaDesinchar);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
