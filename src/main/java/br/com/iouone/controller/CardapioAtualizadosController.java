package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.CardapioAtualizados;
import br.com.iouone.service.CardapioAtualizadosService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/cardapios-atualizados")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
@CrossOrigin
public class CardapioAtualizadosController {

    @Autowired
    private CardapioAtualizadosService service;

    @GetMapping
    public List<CardapioAtualizados> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardapioAtualizados> getById(@PathVariable Integer id) {
        Optional<CardapioAtualizados> cardapio = service.findById(id);
        return cardapio.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CardapioAtualizados create(@RequestBody CardapioAtualizados cardapioAtualizados) {
        return service.create(cardapioAtualizados);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardapioAtualizados> update(@PathVariable Integer id, @RequestBody CardapioAtualizados cardapioAtualizados) {
        CardapioAtualizados updated = service.update(id, cardapioAtualizados);
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
