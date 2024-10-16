package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.Exercicio;
import br.com.iouone.service.ExercicioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/exercicios")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
public class ExercicioController {

    @Autowired
    private ExercicioService service;

    @GetMapping
    public List<Exercicio> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercicio> getById(@PathVariable Integer id) {
        Optional<Exercicio> exercicio = service.findById(id);
        return exercicio.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Exercicio create(@RequestBody Exercicio exercicio) {
        return service.create(exercicio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercicio> update(@PathVariable Integer id, @RequestBody Exercicio exercicio) {
        Exercicio updatedExercicio = service.update(id, exercicio);
        if (updatedExercicio != null) {
            return ResponseEntity.ok(updatedExercicio);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
