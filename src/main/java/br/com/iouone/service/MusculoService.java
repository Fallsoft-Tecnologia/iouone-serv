package br.com.iouone.service;

import br.com.iouone.entity.Musculo;
import br.com.iouone.repository.MusculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusculoService {

    @Autowired
    private MusculoRepository repository;

    public List<Musculo> findAll() {
        return repository.findAll();
    }

    public Optional<Musculo> findById(Integer id) {
        return repository.findById(id);
    }

    public Musculo create(Musculo musculo) {
        return repository.save(musculo);
    }

    public Musculo update(Integer id, Musculo musculo) {
        Optional<Musculo> existing = repository.findById(id);
        if (existing.isPresent()) {
            Musculo updatedMusculo = existing.get();
            updatedMusculo.setMusculo(musculo.getMusculo());
            return repository.save(updatedMusculo);
        }
        return null;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
