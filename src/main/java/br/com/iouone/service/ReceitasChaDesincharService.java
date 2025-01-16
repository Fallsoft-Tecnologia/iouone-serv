package br.com.iouone.service;

import br.com.iouone.entity.ReceitasChaDesinchar;
import br.com.iouone.repository.ReceitasChaDesincharRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitasChaDesincharService {

    @Autowired
    private ReceitasChaDesincharRepository repository;

    public List<ReceitasChaDesinchar> findAll() {
        return repository.findAll();
    }

    public Optional<ReceitasChaDesinchar> findById(Integer id) {
        return repository.findById(id);
    }

    public ReceitasChaDesinchar save(ReceitasChaDesinchar receitasChaDesinchar) {
        return repository.save(receitasChaDesinchar);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
