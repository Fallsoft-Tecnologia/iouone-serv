package br.com.iouone.controller;

import br.com.iouone.dto.CalculoTDEEDTO;
import br.com.iouone.dto.CriarCalculoRequestDTO;
import br.com.iouone.dto.PessoaCalculoDTO;
import br.com.iouone.service.TDEECalculatorService;
import br.com.iouone.util.JwtUtil;
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

//    @GetMapping("/{pessoaId}")
//    public ResponseEntity<PessoaCalculoDTO> calcularTDEE(@RequestHeader("Authorization") String authHeader,
//                                                         @PathVariable int pessoaId,
//                                                         @RequestParam int objetivoId,
//                                                         @RequestParam int biotipoId) {
//        try {
//            String token = authHeader.replace("Bearer ", ""); // Remove "Bearer "
//            String userId = JwtUtil.getUserIdFromToken(token);
//
//            PessoaCalculoDTO pessoaCalculoDTO = tdeeCalculatorService.calcularTDEE(Integer.parseInt(userId), objetivoId, biotipoId);
//            return ResponseEntity.ok(pessoaCalculoDTO);
//        } catch (IllegalArgumentException e) {
//            logger.warn("Erro de argumento inválido: {}", e.getMessage());
//            return ResponseEntity.badRequest().body(null);
//        } catch (Exception e) {
//            logger.error("Erro inesperado ao calcular TDEE", e);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }

    @PostMapping
    public ResponseEntity<CalculoTDEEDTO> criarCalculoTDEE(@RequestHeader("Authorization") String authHeader,
                                                             @RequestBody CriarCalculoRequestDTO request) {
        try {
            String token = authHeader.replace("Bearer ", ""); // Remove "Bearer "
            String userId = JwtUtil.getUserIdFromToken(token);

            CalculoTDEEDTO pessoaCalculoDTO = tdeeCalculatorService.criarCalculoAutomaticamente(Integer.parseInt(userId), request);

            return ResponseEntity.status(HttpStatus.CREATED).body(pessoaCalculoDTO);
        } catch (IllegalArgumentException e) {
            logger.warn("Erro de argumento inválido ao criar cálculo TDEE: {}", e.getMessage());
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            logger.error("Erro inesperado ao criar cálculo TDEE", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("dados-pessoa")
    public ResponseEntity<?> listarDadosPessoaTDEE(@RequestHeader("Authorization") String authHeader) {
        try {
            String token = authHeader.replace("Bearer ", ""); // Remove "Bearer "
            String userId = JwtUtil.getUserIdFromToken(token);


            return ResponseEntity.status(HttpStatus.OK).body(tdeeCalculatorService.buscarDadosPessoaTDEE(Integer.parseInt(userId)));
        } catch (Exception e) {
            logger.error("Erro inesperado ao criar cálculo TDEE", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}