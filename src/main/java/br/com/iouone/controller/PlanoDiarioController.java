package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.service.PlanoDiarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/plano-diario")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
@CrossOrigin
public class PlanoDiarioController {

    private final PlanoDiarioService planoDiarioService;

    @Autowired
    public PlanoDiarioController(PlanoDiarioService planoDiarioService) {
        this.planoDiarioService = planoDiarioService;
    }

    @GetMapping("/dados")
    public ResponseEntity<?> buscarReceitaMarmita(@RequestParam("id") Integer id,
                                                  @RequestParam("tipo") String tipo) {
        try {
            return ResponseEntity.ok(planoDiarioService.getPlanoDiario(id,tipo));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
