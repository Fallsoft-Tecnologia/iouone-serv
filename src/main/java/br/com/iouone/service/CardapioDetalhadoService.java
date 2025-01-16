package br.com.iouone.service;

import br.com.iouone.entity.CardapioDetalhado;
import br.com.iouone.repository.CardapioDetalhadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardapioDetalhadoService {

    @Autowired
    private CardapioDetalhadoRepository repository;

    public List<CardapioDetalhado> findAll() {
        return repository.findAll();
    }

    public Optional<CardapioDetalhado> findById(Integer id) {
        return repository.findById(id);
    }

    public CardapioDetalhado create(CardapioDetalhado cardapioDetalhado) {
        return repository.save(cardapioDetalhado);
    }

    public CardapioDetalhado update(Integer id, CardapioDetalhado cardapioDetalhado) {
        Optional<CardapioDetalhado> existing = repository.findById(id);
        if (existing.isPresent()) {
            CardapioDetalhado cardapio = existing.get();
            cardapio.setQuantidade(cardapioDetalhado.getQuantidade());
            cardapio.setIdCardapioAtualizados(cardapioDetalhado.getIdCardapioAtualizados());
            cardapio.setIdAlimentacoesDiarias(cardapioDetalhado.getIdAlimentacoesDiarias());
            cardapio.setIdDiaSemana(cardapioDetalhado.getIdDiaSemana());
            cardapio.setIdUnidadeDeMedida(cardapioDetalhado.getIdUnidadeDeMedida());
            cardapio.setIdIngredientes(cardapioDetalhado.getIdIngredientes());
            return repository.save(cardapio);
        }
        return null;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
