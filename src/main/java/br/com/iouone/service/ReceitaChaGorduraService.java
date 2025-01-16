package br.com.iouone.service;

import br.com.iouone.entity.ReceitaChaGordura;
import br.com.iouone.repository.ReceitaChaGorduraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaChaGorduraService {

    @Autowired
    private ReceitaChaGorduraRepository receitaChaGorduraRepository;

    public List<ReceitaChaGordura> findAll() {
        return receitaChaGorduraRepository.findAll();
    }

    public Optional<ReceitaChaGordura> findById(Integer id) {
        return receitaChaGorduraRepository.findById(id);
    }

    public ReceitaChaGordura save(ReceitaChaGordura receitaChaGordura) {
        return receitaChaGorduraRepository.save(receitaChaGordura);
    }

    public void deleteById(Integer id) {
        receitaChaGorduraRepository.deleteById(id);
    }
}
