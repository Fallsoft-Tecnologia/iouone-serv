package br.com.iouone.controller;

import br.com.iouone.dto.CriarCalculoRequestDTO;
import br.com.iouone.dto.PessoaCalculoDTO;
import br.com.iouone.service.TDEECalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/tdee")
@CrossOrigin
public class TDEECalculatorController {

    private static final Logger logger = LoggerFactory.getLogger(TDEECalculatorController.class);
    private final TDEECalculatorService tdeeCalculatorService;

    public TDEECalculatorController(TDEECalculatorService tdeeCalculatorService) {
        this.tdeeCalculatorService = tdeeCalculatorService;
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<PessoaCalculoDTO> calcularTDEE(
            @PathVariable int pessoaId,
            @RequestParam int objetivoId,
            @RequestParam int biotipoId) {
        try {
            PessoaCalculoDTO pessoaCalculoDTO = tdeeCalculatorService.calcularTDEE(pessoaId, objetivoId, biotipoId);
            return ResponseEntity.ok(pessoaCalculoDTO);
        } catch (IllegalArgumentException e) {
            logger.warn("Erro de argumento inválido: {}", e.getMessage());
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            logger.error("Erro inesperado ao calcular TDEE", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<PessoaCalculoDTO> criarCalculoTDEE(@RequestBody CriarCalculoRequestDTO request) {
        try {
            PessoaCalculoDTO pessoaCalculoDTO = tdeeCalculatorService.criarCalculoAutomaticamente(
                    request.getPessoaId(), request.getObjetivoId(), request.getBiotipoId(), request.getDataCalculo()
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(pessoaCalculoDTO);
        } catch (IllegalArgumentException e) {
            logger.warn("Erro de argumento inválido ao criar cálculo TDEE: {}", e.getMessage());
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            logger.error("Erro inesperado ao criar cálculo TDEE", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}