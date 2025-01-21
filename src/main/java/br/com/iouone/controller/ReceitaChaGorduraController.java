package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.ReceitaChaGordura;
import br.com.iouone.service.ReceitaChaGorduraService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/alimentacoes-diarias")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
@CrossOrigin
public class ReceitaChaGorduraController {

    @Autowired
    private ReceitaChaGorduraService receitaChaGorduraService;

    @GetMapping("/receitas-cha-gordura")
    public List<ReceitaChaGordura> getAll() {
        return receitaChaGorduraService.findAll();
    }

    @GetMapping("/receitas-cha-gordura/{id}")
    public ResponseEntity<ReceitaChaGordura> getById(@PathVariable Integer id) {
        return receitaChaGorduraService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/receitas-cha-gordura")
    public ReceitaChaGordura create(@RequestBody ReceitaChaGordura receitaChaGordura) {
        return receitaChaGorduraService.save(receitaChaGordura);
    }

    @PutMapping("/receitas-cha-gordura/{id}")
    public ResponseEntity<ReceitaChaGordura> update(@PathVariable Integer id, @RequestBody ReceitaChaGordura receitaChaGordura) {
        return receitaChaGorduraService.findById(id)
                .map(existingReceita -> {
                    receitaChaGordura.setId(existingReceita.getId());
                    return ResponseEntity.ok(receitaChaGorduraService.save(receitaChaGordura));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/receitas-cha-gordura/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (receitaChaGorduraService.findById(id).isPresent()) {
            receitaChaGorduraService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
