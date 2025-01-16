package br.com.iouone.service;

import br.com.iouone.entity.TreinoAtualizado;
import br.com.iouone.repository.TreinoAtualizadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinoAtualizadoService {

    @Autowired
    private TreinoAtualizadoRepository repository;

    public List<TreinoAtualizado> findAll() {
        return repository.findAll();
    }

    public Optional<TreinoAtualizado> findById(Integer id) {
        return repository.findById(id);
    }

    public TreinoAtualizado save(TreinoAtualizado treinoAtualizado) {
        return repository.save(treinoAtualizado);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
