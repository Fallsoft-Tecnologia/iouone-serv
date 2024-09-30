package br.com.iouone.service;

import br.com.iouone.entity.TipoFitDance;
import br.com.iouone.repository.TipoFitDanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoFitDanceService {

    @Autowired
    private TipoFitDanceRepository repository;

    public List<TipoFitDance> findAll() {
        return repository.findAll();
    }

    public Optional<TipoFitDance> findById(Integer id) {
        return repository.findById(id);
    }

    public TipoFitDance save(TipoFitDance tipoFitDance) {
        return repository.save(tipoFitDance);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
