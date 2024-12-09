package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.dto.ComentarioDTO;
import br.com.iouone.dto.MensagemDTO;
import br.com.iouone.dto.MensagemRequestDTO;
import br.com.iouone.entity.Mensagens;
import br.com.iouone.entity.Pessoa;
import br.com.iouone.repository.MensagensRepository;
import br.com.iouone.repository.PessoaRepository;
import br.com.iouone.service.MensagensService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/mensagens")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
public class MensagensController {

    @Autowired
    private MensagensService mensagensService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private MensagensRepository mensagensRepository;

    @Autowired
    private JwtDecoder jwtDecoder;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mensagens> createMensagem(@RequestHeader("Authorization") String authorization, @RequestBody Mensagens novaMensagem) {
        String token = authorization.substring(7);
        Long userId;
        try {
            Jwt jwt = jwtDecoder.decode(token);
            userId = jwt.getClaim("id");
        } catch (JwtException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Pessoa pessoa = pessoaRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        novaMensagem.setPessoa(pessoa);
        Mensagens mensagemCriada = mensagensService.createMensagem(novaMensagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagemCriada);
    }


    @GetMapping
    public ResponseEntity<Page<MensagemDTO>> getAllMensagens(
            @RequestParam int page,
            @RequestParam int size) {
        Page<MensagemDTO> mensagens = mensagensService.getAllMensagens(page, size);
        return ResponseEntity.ok(mensagens);
    }

    @GetMapping("/comentarios")
    public ResponseEntity<?> obterComentariosPorMensagem(@RequestBody MensagemRequestDTO mensagemIdRequest,
                                                         @RequestParam int page,
                                                         @RequestParam int size) {
        try {
            List<ComentarioDTO> comentarios = mensagensService.obterComentariosIniciaisPorMensagem(
                    mensagemIdRequest.getMensagemId(),
                    page,
                    size
            );
            return ResponseEntity.ok(comentarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao buscar comentários: " + e.getMessage());
        }
    }

    @GetMapping("/subcomentarios")
    public ResponseEntity<List<ComentarioDTO>> obterSubcomentarios(
            @RequestParam int comentarioPaiId,
            @RequestParam int page,
            @RequestParam int size) {
        try {
            List<ComentarioDTO> subcomentarios = mensagensService.obterSubcomentarios(comentarioPaiId, page, size);
            return ResponseEntity.ok(subcomentarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
