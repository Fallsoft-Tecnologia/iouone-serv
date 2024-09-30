package br.com.iouone.service;

import br.com.iouone.entity.MarmitaFit;
import br.com.iouone.repository.MarmitaFitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarmitaFitService {

    @Autowired
    private MarmitaFitRepository repository;

    public List<MarmitaFit> findAll() {
        return repository.findAll();
    }

    public Optional<MarmitaFit> findById(Integer id) {
        return repository.findById(id);
    }

    public MarmitaFit create(MarmitaFit marmitaFit) {
        return repository.save(marmitaFit);
    }

    public MarmitaFit update(Integer id, MarmitaFit marmitaFit) {
        Optional<MarmitaFit> existing = repository.findById(id);
        if (existing.isPresent()) {
            MarmitaFit updatedMarmitaFit = existing.get();
            updatedMarmitaFit.setNome(marmitaFit.getNome());
            updatedMarmitaFit.setDescricao(marmitaFit.getDescricao());
            updatedMarmitaFit.setModoDePreparo(marmitaFit.getModoDePreparo());
            updatedMarmitaFit.setFoto(marmitaFit.getFoto());
            return repository.save(updatedMarmitaFit);
        }
        return null;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
