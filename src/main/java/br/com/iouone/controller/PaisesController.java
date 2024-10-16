package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.entity.AtividadeFisica;
import br.com.iouone.entity.Paises;
import br.com.iouone.service.PaisesService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/paises")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
public class PaisesController {

    @Autowired
    private PaisesService paisesService;


    @GetMapping
    public List<Paises> getAllPaises() {
        return paisesService.getAllPaises();
    }
}
