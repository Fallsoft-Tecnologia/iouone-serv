package br.com.iouone.service;

import br.com.iouone.entity.DiaSemana;
import br.com.iouone.repository.DiaSemanaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiaSemanaService {

    @Autowired
    private DiaSemanaRepository repository;

    public List<DiaSemana> findAll() {
        return repository.findAll();
    }

    public Optional<DiaSemana> findById(Integer id) {
        return repository.findById(id);
    }

    public DiaSemana save(DiaSemana diaSemana) {
        return repository.save(diaSemana);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
