package br.com.iouone.service;

import br.com.iouone.entity.Detox;
import br.com.iouone.repository.DetoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetoxService {

    @Autowired
    private DetoxRepository repository;

    public List<Detox> findAll() {
        return repository.findAll();
    }

    public Optional<Detox> findById(Integer id) {
        return repository.findById(id);
    }

    public Detox create(Detox detox) {
        return repository.save(detox);
    }

    public Detox update(Integer id, Detox detox) {
        Optional<Detox> existing = repository.findById(id);
        if (existing.isPresent()) {
            Detox existingDetox = existing.get();
            existingDetox.setNome(detox.getNome());
            existingDetox.setDescricao(detox.getDescricao());
            existingDetox.setModoDePreparo(detox.getModoDePreparo());
            existingDetox.setFoto(detox.getFoto());
            return repository.save(existingDetox);
        }
        return null;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
