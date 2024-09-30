package br.com.iouone.service;

import br.com.iouone.entity.DietasAtualizadas;
import br.com.iouone.repository.DietasAtualizadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DietasAtualizadasService {

    @Autowired
    private DietasAtualizadasRepository repository;

    public List<DietasAtualizadas> findAll() {
        return repository.findAll();
    }

    public Optional<DietasAtualizadas> findById(Integer id) {
        return repository.findById(id);
    }

    public DietasAtualizadas create(DietasAtualizadas dieta) {
        return repository.save(dieta);
    }

    public DietasAtualizadas update(Integer id, DietasAtualizadas dieta) {
        Optional<DietasAtualizadas> existing = repository.findById(id);
        if (existing.isPresent()) {
            DietasAtualizadas existingDieta = existing.get();
            existingDieta.setNome(dieta.getNome());
            existingDieta.setDescricao(dieta.getDescricao());
            existingDieta.setFoto(dieta.getFoto());
            return repository.save(existingDieta);
        }
        return null;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
