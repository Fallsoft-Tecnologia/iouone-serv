package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.dto.ComentarioRequest;
import br.com.iouone.service.ComentarioMensagemService;
import br.com.iouone.service.MensagensService;
import br.com.iouone.util.JwtUtil;
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


    @PostMapping("/{mensagemId}/comentarios")
    public ResponseEntity<?> adicionarComentario(@RequestHeader("Authorization") String token ,@Valid @PathVariable int mensagemId, @RequestBody ComentarioRequest comentarioRequest) {
        var idUsuario = JwtUtil.getUserIdFromToken(token);

        Integer idComentarioPai = comentarioRequest.getIdComentarioPai();
        String mensagemComentario = comentarioRequest.getMensagemComentario();

        var comentario = comentarioMensagemService.adicionarComentario(mensagemId, mensagemComentario, idComentarioPai,Integer.parseInt(idUsuario));

        return ResponseEntity.ok(comentario);
    }

}
