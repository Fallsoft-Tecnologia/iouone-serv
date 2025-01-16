package br.com.iouone.service;

import br.com.iouone.entity.Ingredientes;
import br.com.iouone.repository.IngredientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientesService {

    @Autowired
    private IngredientesRepository repository;

    public List<Ingredientes> findAll() {
        return repository.findAll();
    }

    public Optional<Ingredientes> findById(Integer id) {
        return repository.findById(id);
    }

    public Ingredientes create(Ingredientes ingrediente) {
        return repository.save(ingrediente);
    }

    public Ingredientes update(Integer id, Ingredientes ingrediente) {
        Optional<Ingredientes> existing = repository.findById(id);
        if (existing.isPresent()) {
            Ingredientes updatedIngrediente = existing.get();
            updatedIngrediente.setNome(ingrediente.getNome());
            return repository.save(updatedIngrediente);
        }
        return null;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
