package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.Detox;
import br.com.iouone.service.DetoxService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/detox")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
@CrossOrigin
public class DetoxController {

    @Autowired
    private DetoxService service;

    @GetMapping
    public List<Detox> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Detox> getById(@PathVariable Integer id) {
        Optional<Detox> detox = service.findById(id);
        return detox.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Detox create(@RequestBody Detox detox) {
        return service.create(detox);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Detox> update(@PathVariable Integer id, @RequestBody Detox detox) {
        Detox updated = service.update(id, detox);
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
