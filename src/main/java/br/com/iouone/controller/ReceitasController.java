package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.service.ReceitasService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/receitas")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
@CrossOrigin
public class ReceitasController {

    private final ReceitasService receitasService;

    @Autowired
    public ReceitasController(ReceitasService receitasService) {
        this.receitasService = receitasService;
    }

    @GetMapping("/dados")
    public ResponseEntity<?> buscarReceitaMarmita(@RequestParam("id") Integer id,
                                                  @RequestParam("tipo") String tipo) {
        try {
            return ResponseEntity.ok(receitasService.getReceitas(id,tipo));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
