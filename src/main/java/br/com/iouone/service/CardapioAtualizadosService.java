package br.com.iouone.service;

import br.com.iouone.entity.CardapioAtualizados;
import br.com.iouone.repository.CardapioAtualizadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CardapioAtualizadosService {

    @Autowired
    private CardapioAtualizadosRepository repository;

    public List<CardapioAtualizados> findAll() {
        return repository.findAll();
    }

    public Optional<CardapioAtualizados> findById(Integer id) {
        return repository.findById(id);
    }

    public CardapioAtualizados create(CardapioAtualizados cardapioAtualizados) {
        return repository.save(cardapioAtualizados);
    }

    public CardapioAtualizados update(Integer id, CardapioAtualizados cardapioAtualizados) {
        Optional<CardapioAtualizados> existing = repository.findById(id);
        if (existing.isPresent()) {
            CardapioAtualizados cardapio = existing.get();
            cardapio.setNome(cardapioAtualizados.getNome());
            cardapio.setDescricao(cardapioAtualizados.getDescricao());
            cardapio.setFoto(cardapioAtualizados.getFoto());
            return repository.save(cardapio);
        }
        return null;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public void saveImage(Integer id, MultipartFile image) throws IOException {

        var retornoCardapioAtualizado = findById(id).orElseThrow(() -> new RuntimeException("Cardapio Atualizado nao encontrada"));
        retornoCardapioAtualizado.setFoto(image.getBytes());
        create(retornoCardapioAtualizado);
    }
}
