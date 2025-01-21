package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.CardapioDetalhado;
import br.com.iouone.service.CardapioDetalhadoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/cardapios-detalhados")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
@CrossOrigin
public class CardapioDetalhadoController {

    @Autowired
    private CardapioDetalhadoService service;

    @GetMapping
    public List<CardapioDetalhado> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardapioDetalhado> getById(@PathVariable Integer id) {
        Optional<CardapioDetalhado> cardapioDetalhado = service.findById(id);
        return cardapioDetalhado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CardapioDetalhado create(@RequestBody CardapioDetalhado cardapioDetalhado) {
        return service.create(cardapioDetalhado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardapioDetalhado> update(@PathVariable Integer id, @RequestBody CardapioDetalhado cardapioDetalhado) {
        CardapioDetalhado updated = service.update(id, cardapioDetalhado);
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
