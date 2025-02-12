package br.com.iouone.service;

import br.com.iouone.entity.ChaDesinchar;
import br.com.iouone.repository.ChaDesincharRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ChaDesincharService {

    @Autowired
    private ChaDesincharRepository repository;

    public List<ChaDesinchar> findAll() {
        return repository.findAll();
    }

    public Optional<ChaDesinchar> findById(Integer id) {
        return repository.findById(id);
    }

    public ChaDesinchar create(ChaDesinchar chaDesinchar) {
        return repository.save(chaDesinchar);
    }

    public ChaDesinchar update(Integer id, ChaDesinchar chaDesinchar) {
        Optional<ChaDesinchar> existing = repository.findById(id);
        if (existing.isPresent()) {
            ChaDesinchar cha = existing.get();
            cha.setNome(chaDesinchar.getNome());
            cha.setDescricao(chaDesinchar.getDescricao());
            cha.setFoto(chaDesinchar.getFoto());
            return repository.save(cha);
        }
        return null;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public void saveImage(Integer id, MultipartFile image) throws IOException {

        var retornoCha = findById(id).orElseThrow(() -> new RuntimeException("Cha nao encontrada"));
        retornoCha.setFoto(image.getBytes());
        create(retornoCha);
    }
}
