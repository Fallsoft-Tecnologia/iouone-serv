package br.com.iouone.service;

import br.com.iouone.entity.FitDance;
import br.com.iouone.repository.FitDanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FitDanceService {

    @Autowired
    private FitDanceRepository repository;

    public List<FitDance> findAll() {
        return repository.findAll();
    }

    public Optional<FitDance> findById(Integer id) {
        return repository.findById(id);
    }

    public FitDance create(FitDance fitDance) {
        return repository.save(fitDance);
    }

    public FitDance update(Integer id, FitDance fitDance) {
        Optional<FitDance> existing = repository.findById(id);
        if (existing.isPresent()) {
            FitDance updatedFitDance = existing.get();
            updatedFitDance.setNome(fitDance.getNome());
            updatedFitDance.setUrlFitDance(fitDance.getUrlFitDance());
            updatedFitDance.setVideo(fitDance.getVideo());
            updatedFitDance.setContadorVistos(fitDance.getContadorVistos());
            updatedFitDance.setTipoFitDance(fitDance.getTipoFitDance());
            updatedFitDance.setAutor(fitDance.getAutor());
            updatedFitDance.setFoto(fitDance.getFoto());
            return repository.save(updatedFitDance);
        }
        return null;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public void saveImage(Integer id, MultipartFile image) throws IOException {

        var retornoFitDance = findById(id).orElseThrow(() -> new RuntimeException("Fit Dance nao encontrada"));
        retornoFitDance.setFoto(image.getBytes());
        create(retornoFitDance);
    }
}
