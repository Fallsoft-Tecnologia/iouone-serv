package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.DietasAtualizadas;
import br.com.iouone.service.DietasAtualizadasService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/dietas-atualizadas")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
@CrossOrigin
public class DietasAtualizadasController {

    @Autowired
    private DietasAtualizadasService service;

    @GetMapping
    public List<DietasAtualizadas> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DietasAtualizadas> getById(@PathVariable Integer id) {
        Optional<DietasAtualizadas> dieta = service.findById(id);
        return dieta.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DietasAtualizadas create(@RequestBody DietasAtualizadas dieta) {
        return service.create(dieta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DietasAtualizadas> update(@PathVariable Integer id, @RequestBody DietasAtualizadas dieta) {
        DietasAtualizadas updated = service.update(id, dieta);
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

    @PostMapping(value = "/cadastro/image/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> insertPhotos(@RequestPart("anexo") MultipartFile multipartFile,
                                          @PathVariable Integer id){
        try {
            service.saveImage(id,multipartFile);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
}
