package br.com.iouone.service;

import br.com.iouone.entity.Exercicio;
import br.com.iouone.repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository repository;

    public List<Exercicio> findAll() {
        return repository.findAll();
    }

    public Optional<Exercicio> findById(Integer id) {
        return repository.findById(id);
    }

    public Exercicio create(Exercicio exercicio) {
        return repository.save(exercicio);
    }

    public Exercicio update(Integer id, Exercicio exercicio) {
        Optional<Exercicio> existing = repository.findById(id);
        if (existing.isPresent()) {
            Exercicio updatedExercicio = existing.get();
            updatedExercicio.setExercicio(exercicio.getExercicio());
            return repository.save(updatedExercicio);
        }
        return null;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
