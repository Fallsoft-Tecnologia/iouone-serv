package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.FitDance;
import br.com.iouone.service.FitDanceService;
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
@RequestMapping("/api/v2/fit-dance")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
@CrossOrigin
public class FitDanceController {

    @Autowired
    private FitDanceService service;

    @GetMapping
    public List<FitDance> getAll(@RequestHeader("Authorization") String authHeader) {

        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FitDance> getById(@PathVariable Integer id) {
        Optional<FitDance> fitDance = service.findById(id);
        return fitDance.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public FitDance create(@RequestBody FitDance fitDance) {
        return service.create(fitDance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FitDance> update(@PathVariable Integer id, @RequestBody FitDance fitDance) {
        FitDance updatedFitDance = service.update(id, fitDance);
        if (updatedFitDance != null) {
            return ResponseEntity.ok(updatedFitDance);
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
