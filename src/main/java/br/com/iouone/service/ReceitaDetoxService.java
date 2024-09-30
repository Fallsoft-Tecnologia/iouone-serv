package br.com.iouone.service;

import br.com.iouone.entity.ReceitaDetox;
import br.com.iouone.repository.ReceitaDetoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaDetoxService {

    @Autowired
    private ReceitaDetoxRepository receitaDetoxRepository;

    public List<ReceitaDetox> findAll() {
        return receitaDetoxRepository.findAll();
    }

    public Optional<ReceitaDetox> findById(Integer id) {
        return receitaDetoxRepository.findById(id);
    }

    public ReceitaDetox save(ReceitaDetox receitaDetox) {
        return receitaDetoxRepository.save(receitaDetox);
    }

    public void deleteById(Integer id) {
        receitaDetoxRepository.deleteById(id);
    }
}
