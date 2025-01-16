package br.com.iouone.service;

import br.com.iouone.entity.TreinoCompleto;
import br.com.iouone.repository.TreinoCompletoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinoCompletoService {

    @Autowired
    private TreinoCompletoRepository repository;

    public List<TreinoCompleto> findAll() {
        return repository.findAll();
    }

    public Optional<TreinoCompleto> findById(Integer id) {
        return repository.findById(id);
    }

    public TreinoCompleto save(TreinoCompleto treinoCompleto) {
        return repository.save(treinoCompleto);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
