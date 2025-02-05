package br.com.iouone.service;

import br.com.iouone.entity.ExercicioEmCasa;
import br.com.iouone.repository.ExercicioEmCasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ExercicioEmCasaService {

    @Autowired
    private ExercicioEmCasaRepository repository;

    public List<ExercicioEmCasa> findAll() {
        return repository.findAll();
    }

    public Optional<ExercicioEmCasa> findById(Integer id) {
        return repository.findById(id);
    }

    public ExercicioEmCasa create(ExercicioEmCasa exercicioEmCasa) {
        return repository.save(exercicioEmCasa);
    }

    public ExercicioEmCasa update(Integer id, ExercicioEmCasa exercicioEmCasa) {
        Optional<ExercicioEmCasa> existing = repository.findById(id);
        if (existing.isPresent()) {
            ExercicioEmCasa updatedExercicio = existing.get();
            updatedExercicio.setNome(exercicioEmCasa.getNome());
            updatedExercicio.setUrlTreinoCasa(exercicioEmCasa.getUrlTreinoCasa());
            updatedExercicio.setFoto(exercicioEmCasa.getFoto());
            updatedExercicio.setVideo(exercicioEmCasa.getVideo());
            return repository.save(updatedExercicio);
        }
        return null;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public void saveImage(Integer id, MultipartFile image) throws IOException {

        var retornoExercicioEmCasa = findById(id).orElseThrow(() -> new RuntimeException("Exercicio em casa nao encontrada"));
        retornoExercicioEmCasa.setFoto(image.getBytes());
        create(retornoExercicioEmCasa);
    }
}
