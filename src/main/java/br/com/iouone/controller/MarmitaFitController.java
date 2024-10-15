package br.com.iouone.controller;

import br.com.iouone.dto.MarmitaFitDTO;
import br.com.iouone.entity.MarmitaFit;
import br.com.iouone.service.MarmitaFitService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/marmitas-fit")
public class MarmitaFitController {

    @Autowired
    private MarmitaFitService service;

    @GetMapping
    public List<MarmitaFit> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarmitaFit> getById(@PathVariable Integer id) {
        Optional<MarmitaFit> marmitaFit = service.findById(id);
        return marmitaFit.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MarmitaFit create(@RequestBody MarmitaFit marmitaFit) {
        return service.create(marmitaFit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarmitaFit> update(@PathVariable Integer id, @RequestBody MarmitaFit marmitaFit) {
        MarmitaFit updatedMarmitaFit = service.update(id, marmitaFit);
        if (updatedMarmitaFit != null) {
            return ResponseEntity.ok(updatedMarmitaFit);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/detalhes")
    public ResponseEntity<MarmitaFitDTO> getMarmitaFitWithIngredients(@PathVariable Integer id) {
        try {
            MarmitaFitDTO marmitaFitDTO = service.getMarmitaFitWithIngredients(id);
            return ResponseEntity.ok(marmitaFitDTO);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
