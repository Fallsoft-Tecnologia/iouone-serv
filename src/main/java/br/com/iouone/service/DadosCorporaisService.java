package br.com.iouone.service;

import br.com.iouone.entity.DadosCorporais;
import br.com.iouone.repository.DadosCorporaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DadosCorporaisService {

    @Autowired
    private DadosCorporaisRepository dadosCorporaisRepository;

    public DadosCorporais saveDadosCorporais(DadosCorporais dadosCorporais) {
        return dadosCorporaisRepository.save(dadosCorporais);
    }
}
