package br.com.iouone.service;

import br.com.iouone.entity.AtividadeFisica;
import br.com.iouone.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeFisicaService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public AtividadeFisica buscarAtividadeFisicaPorId(Integer id) {
        return atividadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atividade Fisica não exitente"));
    }

    public List<AtividadeFisica> buscarAtividadeFisicas() {
        return atividadeRepository.findAll();
    }

    public AtividadeFisica buscarAtividadeFisicaPorNome(String nome) {
        return atividadeRepository.findAtividadeFisicaByAtividadeFisica(nome);
    }
}
