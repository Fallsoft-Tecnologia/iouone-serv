package br.com.iouone.service;

import br.com.iouone.dto.PlanoDiarioResponse;
import br.com.iouone.dto.ItensDietaDetalhadaDTO;
import br.com.iouone.entity.DietaDetalhada;
import br.com.iouone.mapper.PlanosDiariosMapper;
import br.com.iouone.repository.DietaDetalhadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DietaDetalhadaService {

    @Autowired
    private DietaDetalhadaRepository repository;

    public List<DietaDetalhada> findAll() {
        return repository.findAll();
    }

    public Optional<DietaDetalhada> findById(Integer id) {
        return repository.findById(id);
    }

    public DietaDetalhada create(DietaDetalhada dietaDetalhada) {
        return repository.save(dietaDetalhada);
    }

    public DietaDetalhada update(Integer id, DietaDetalhada dietaDetalhada) {
        Optional<DietaDetalhada> existing = repository.findById(id);
        if (existing.isPresent()) {
            DietaDetalhada existingDietaDetalhada = existing.get();
            existingDietaDetalhada.setAlimentacoesDiarias(dietaDetalhada.getAlimentacoesDiarias());
            existingDietaDetalhada.setDietasAtualizadas(dietaDetalhada.getDietasAtualizadas());
            existingDietaDetalhada.setDietas(dietaDetalhada.getDietas());
            return repository.save(existingDietaDetalhada);
        }
        return null;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public PlanoDiarioResponse buscarDietaDetalhadasPorAlimentacao(Integer idDietaDetalhada) {
        var dados = repository.buscarDadosDieta(idDietaDetalhada);
        return PlanosDiariosMapper.dtoToPlanoDiarioResponse(dados);
    }
}
