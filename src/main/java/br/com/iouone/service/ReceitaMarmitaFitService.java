package br.com.iouone.service;

import br.com.iouone.entity.ReceitaMarmitaFit;
import br.com.iouone.repository.ReceitaMarmitaFitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaMarmitaFitService {

    @Autowired
    private ReceitaMarmitaFitRepository repository;

    public List<ReceitaMarmitaFit> findAll() {
        return repository.findAll();
    }

    public Optional<ReceitaMarmitaFit> findById(Integer id) {
        return repository.findById(id);
    }

    public ReceitaMarmitaFit save(ReceitaMarmitaFit receitaMarmitaFit) {
        return repository.save(receitaMarmitaFit);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
