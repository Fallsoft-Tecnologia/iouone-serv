package br.com.iouone.service;

import br.com.iouone.entity.AlimentacoesDiarias;
import br.com.iouone.repository.AlimentacoesDiariasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlimentacoesDiariasService {

    @Autowired
    private AlimentacoesDiariasRepository repository;

    public List<AlimentacoesDiarias> findAll() {
        return repository.findAll();
    }

    public Optional<AlimentacoesDiarias> findById(Integer id) {
        return repository.findById(id);
    }

    public AlimentacoesDiarias create(AlimentacoesDiarias alimentacoesDiarias) {
        return repository.save(alimentacoesDiarias);
    }

    public AlimentacoesDiarias update(Integer id, AlimentacoesDiarias alimentacoesDiarias) {
        if (repository.existsById(id)) {
            alimentacoesDiarias.setId(id);
            return repository.save(alimentacoesDiarias);
        }
        return null;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
