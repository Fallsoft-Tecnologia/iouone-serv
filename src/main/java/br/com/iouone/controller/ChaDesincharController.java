package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.ChaDesinchar;
import br.com.iouone.service.ChaDesincharService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/cha-desinchar")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
@CrossOrigin
public class ChaDesincharController {

    @Autowired
    private ChaDesincharService service;

    @GetMapping
    public List<ChaDesinchar> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChaDesinchar> getById(@PathVariable Integer id) {
        Optional<ChaDesinchar> chaDesinchar = service.findById(id);
        return chaDesinchar.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ChaDesinchar create(@RequestBody ChaDesinchar chaDesinchar) {
        return service.create(chaDesinchar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChaDesinchar> update(@PathVariable Integer id, @RequestBody ChaDesinchar chaDesinchar) {
        ChaDesinchar updated = service.update(id, chaDesinchar);
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
