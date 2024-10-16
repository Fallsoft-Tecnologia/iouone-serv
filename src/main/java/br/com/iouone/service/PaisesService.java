package br.com.iouone.service;

import br.com.iouone.entity.Paises;
import br.com.iouone.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisesService {

    @Autowired
    private PaisRepository paisRepository;


    public Paises getPaisByAbreviacao(String abreviacao) {
        return paisRepository.findByAbreviacao(abreviacao);
    }

    public List<Paises> getAllPaises() {
        return paisRepository.findAll();
    }


}
