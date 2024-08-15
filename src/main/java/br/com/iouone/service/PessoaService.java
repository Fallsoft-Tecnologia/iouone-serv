package br.com.iouone.service;

import br.com.iouone.dto.PessoaRequest;
import br.com.iouone.dto.PessoaResponse;
import br.com.iouone.entity.AtividadeFisica;
import br.com.iouone.entity.Pessoa;
import br.com.iouone.mapper.PessoaMapper;
import br.com.iouone.repository.AtividadeRepository;
import br.com.iouone.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private AtividadeRepository atividadeFisicaRepository;

    @Autowired
    private PessoaMapper pessoaMapper;

    public PessoaResponse savePessoa(PessoaRequest pessoaRequest) {
        Pessoa pessoa = pessoaMapper.toEntity(pessoaRequest);
        Pessoa savedPessoa = pessoaRepository.save(pessoa);
        return pessoaMapper.toResponse(savedPessoa);
    }

    public Optional<PessoaResponse> findPessoaById(Integer id) {
        return pessoaRepository.findById(id)
                .map(pessoaMapper::toResponse);
    }

    public List<PessoaResponse> findAllPessoas() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoaMapper::toResponse)
                .collect(Collectors.toList());
    }

    public Optional<PessoaResponse> updatePessoa(Integer id, PessoaRequest pessoaRequest) {
        return pessoaRepository.findById(id).map(pessoa -> {
            pessoa.setCpf(pessoaRequest.getCpf());
            pessoa.setNome(pessoaRequest.getNome());
            pessoa.setEmail(pessoaRequest.getEmail());
            pessoa.setCelular(pessoaRequest.getCelular());
            pessoa.setDataNascimento(pessoaRequest.getDataNascimento());

            // Atualizando a atividade física
            if (pessoaRequest.getAtividadeFisicaId() != null) {
                AtividadeFisica atividadeFisica = atividadeFisicaRepository
                        .findById(pessoaRequest.getAtividadeFisicaId())
                        .orElse(null);
                pessoa.setAtividadeFisica(atividadeFisica);
            }

            Pessoa updatedPessoa = pessoaRepository.save(pessoa);
            return pessoaMapper.toResponse(updatedPessoa);
        });
    }

    public boolean deletePessoa(Integer id) {
        return pessoaRepository.findById(id).map(pessoa -> {
            pessoaRepository.delete(pessoa);
            return true;
        }).orElse(false);
    }
}
