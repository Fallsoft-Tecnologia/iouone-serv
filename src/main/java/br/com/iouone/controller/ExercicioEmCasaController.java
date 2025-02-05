package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.ExercicioEmCasa;
import br.com.iouone.service.ExercicioEmCasaService;
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
@RequestMapping("/api/v2/exercicios-casa")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
@CrossOrigin
public class ExercicioEmCasaController {

    @Autowired
    private ExercicioEmCasaService service;

    @GetMapping
    public List<ExercicioEmCasa> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioEmCasa> getById(@PathVariable Integer id) {
        Optional<ExercicioEmCasa> exercicioEmCasa = service.findById(id);
        return exercicioEmCasa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ExercicioEmCasa create(@RequestBody ExercicioEmCasa exercicioEmCasa) {
        return service.create(exercicioEmCasa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExercicioEmCasa> update(@PathVariable Integer id, @RequestBody ExercicioEmCasa exercicioEmCasa) {
        ExercicioEmCasa updatedExercicio = service.update(id, exercicioEmCasa);
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
