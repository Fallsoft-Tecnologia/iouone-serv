package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.dto.ComentarioRequest;
import br.com.iouone.service.ComentarioMensagemService;
import br.com.iouone.service.MensagensService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v2/mensagens")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
@CrossOrigin
public class ComentarioMensagemController {

    @Autowired
    private ComentarioMensagemService comentarioMensagemService;

    @Autowired
    private MensagensService mensagensService;

    @PostMapping("/{mensagemId}/comentarios")
    public ResponseEntity<String> adicionarComentario(@Valid @PathVariable int mensagemId, @RequestBody ComentarioRequest comentarioRequest) {
        Integer idComentarioPai = comentarioRequest.getIdComentarioPai();
        String mensagemComentario = comentarioRequest.getMensagemComentario();

        comentarioMensagemService.adicionarComentario(mensagemId, mensagemComentario, idComentarioPai);

        return ResponseEntity.ok("Comentário adicionado com sucesso!");
    }

}
