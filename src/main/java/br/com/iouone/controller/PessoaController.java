package br.com.iouone.controller;

import br.com.iouone.dto.PessoaRequest;
import br.com.iouone.dto.PessoaResponse;
import br.com.iouone.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
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
}
