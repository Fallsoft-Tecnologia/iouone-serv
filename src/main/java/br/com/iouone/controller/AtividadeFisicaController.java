package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.AlimentacoesDiarias;
import br.com.iouone.entity.AtividadeFisica;
import br.com.iouone.service.AtividadeFisicaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/atividade-fisica")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
public class AtividadeFisicaController {

    @Autowired
    private AtividadeFisicaService atividadeFisicaService;

    @GetMapping
    public List<AtividadeFisica> getAllAtividadesFisicas() {
        return atividadeFisicaService.buscarAtividadeFisicas();
    }


}
