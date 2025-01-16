package br.com.iouone.service;

import br.com.iouone.entity.ChaGordura;
import br.com.iouone.repository.ChaGorduraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChaGorduraService {

    @Autowired
    private ChaGorduraRepository repository;

    public List<ChaGordura> findAll() {
        return repository.findAll();
    }

    public Optional<ChaGordura> findById(Integer id) {
        return repository.findById(id);
    }

    public ChaGordura create(ChaGordura chaGordura) {
        return repository.save(chaGordura);
    }

    public ChaGordura update(Integer id, ChaGordura chaGordura) {
        Optional<ChaGordura> existing = repository.findById(id);
        if (existing.isPresent()) {
            ChaGordura cha = existing.get();
            cha.setNome(chaGordura.getNome());
            cha.setDescricao(chaGordura.getDescricao());
            cha.setModoDePreparo(chaGordura.getModoDePreparo());
            cha.setFoto(chaGordura.getFoto());
            return repository.save(cha);
        }
        return null;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
