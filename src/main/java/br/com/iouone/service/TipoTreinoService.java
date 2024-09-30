package br.com.iouone.service;

import br.com.iouone.entity.TipoTreino;
import br.com.iouone.repository.TipoTreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoTreinoService {

    @Autowired
    private TipoTreinoRepository repository;

    public List<TipoTreino> findAll() {
        return repository.findAll();
    }

    public Optional<TipoTreino> findById(Integer id) {
        return repository.findById(id);
    }

    public TipoTreino save(TipoTreino tipoTreino) {
        return repository.save(tipoTreino);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
