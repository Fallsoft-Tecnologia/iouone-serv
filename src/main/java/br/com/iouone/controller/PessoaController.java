package br.com.iouone.controller;

import br.com.iouone.config.SecurityConstants;
import br.com.iouone.dto.*;
import br.com.iouone.service.PessoaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/pessoas")
@SecurityRequirement(name = SecurityConstants.BEARER_AUTH)
@CrossOrigin
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;


    @PostMapping
    public ResponseEntity<PessoaResponse> createPessoa(@RequestBody PessoaRequest pessoaRequest) {
        PessoaResponse novaPessoa = pessoaService.savePessoa(pessoaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponse> getPessoaById(@PathVariable Integer id) {
        Optional<PessoaResponse> pessoa = pessoaService.findPessoaById(id);
        return pessoa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<PessoaResponse> getAllPessoas() {
        return pessoaService.findAllPessoas();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponse> updatePessoa(@PathVariable Integer id, @RequestBody PessoaRequest pessoaRequest) {
        Optional<PessoaResponse> updatedPessoa = pessoaService.updatePessoa(id, pessoaRequest);
        return updatedPessoa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Integer id) {
        if (pessoaService.deletePessoa(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("cadastro/dados/login")
    public ResponseEntity<ResponseFluxoId> cadastroLoginPessoa(@Valid @RequestBody LoginDTO loginDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.cadastroDadosLogin(loginDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }


    @PostMapping("cadastro/dados/pessoais")
    public ResponseEntity<ResponseFluxoId> cadastroDadosPessoais(@Valid @RequestBody DadosPessoaisPessoaRequest dadosPessoaisPessoaRequest, @RequestHeader("fluxoId") String fluxoId) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.cadastroDadosPessoais(dadosPessoaisPessoaRequest, fluxoId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("cadastro/dados/endereco")
    public ResponseEntity<ResponseFluxoId> cadastroDadosEndereco(@Valid @RequestBody DadosPessoaisEnderecoRequest dadosPessoaisEnderecoRequest, @RequestHeader("fluxoId") String fluxoId) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.cadastroDadosEndereco(dadosPessoaisEnderecoRequest, fluxoId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("cadastro/dados/corporais")
    public ResponseEntity<ResponseFluxoId> cadastroDadosCorporais(@Valid @RequestBody DadosPessoaisCorporaisRequest dadosPessoaisCorporaisRequest, @RequestHeader("fluxoId") String fluxoId) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.cadastroDadosCorporais(dadosPessoaisCorporaisRequest, fluxoId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/dados")
    public ResponseEntity<?> getCadastroDados(@RequestHeader("fluxoId") String fluxoId) {
        try {
            CadastroCompletoDTO cadastroCompleto = pessoaService.getCadastroCompleto(fluxoId);
            return ResponseEntity.ok(cadastroCompleto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
