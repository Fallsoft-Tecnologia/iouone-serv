package br.com.iouone.service;

import br.com.iouone.entity.Endereco;
import br.com.iouone.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;


    public Endereco saveEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}
