package br.com.iouone.service;

import br.com.iouone.entity.UnidadeDeMedida;
import br.com.iouone.repository.UnidadeDeMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeDeMedidaService {

    @Autowired
    private UnidadeDeMedidaRepository repository;

    public List<UnidadeDeMedida> findAll() {
        return repository.findAll();
    }

    public Optional<UnidadeDeMedida> findById(Integer id) {
        return repository.findById(id);
    }

    public UnidadeDeMedida save(UnidadeDeMedida unidadeDeMedida) {
        return repository.save(unidadeDeMedida);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
