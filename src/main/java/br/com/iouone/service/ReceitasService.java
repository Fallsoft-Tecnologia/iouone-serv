package br.com.iouone.service;

import br.com.iouone.dto.ReceitasDTO;
import br.com.iouone.dto.ReceitasResponse;
import br.com.iouone.entity.ReceitaMarmitaFit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ReceitasService {

    private final ReceitasChaDesincharService receitasChaDesincharService;
    private final ReceitaDetoxService receitaDetoxService;
    private final ReceitaMarmitaFitService receitaMarmitaFitService;

    @Autowired
    public ReceitasService(ReceitasChaDesincharService receitasChaDesincharService, ReceitaDetoxService receitaDetoxService, ReceitaMarmitaFitService receitaMarmitaFitService) {
        this.receitasChaDesincharService = receitasChaDesincharService;
        this.receitaDetoxService = receitaDetoxService;
        this.receitaMarmitaFitService = receitaMarmitaFitService;
    }

    public ReceitasResponse getReceitas(Integer id, String tipo) {

        if (Objects.equals(tipo, "chas")) {
            return receitasChaDesincharService.buscarReceitaCha(id);
        } else if (Objects.equals(tipo, "detox")) {
            return receitaDetoxService.buscarReceitaDetox(id);
        } else if (Objects.equals(tipo, "marmita")) {
            return receitaMarmitaFitService.buscarReceitaMarmitaFit(id);
        } else {
            return new ReceitasResponse();
        }

    }
}
