package br.com.iouone.service;

import br.com.iouone.dto.PlanoDiarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanoDiarioService {

    public final CardapioDetalhadoService cardapioDetalhadoService;
    public final DietaDetalhadaService dietaDetalhadaService;

    @Autowired
    public PlanoDiarioService(CardapioDetalhadoService cardapioDetalhadoService, DietaDetalhadaService dietaDetalhadaService) {
        this.cardapioDetalhadoService = cardapioDetalhadoService;
        this.dietaDetalhadaService = dietaDetalhadaService;
    }

    public PlanoDiarioResponse getPlanoDiario(Integer id, String tipo) {
        if (tipo.equals("dietas")) {
            return dietaDetalhadaService.buscarDietaDetalhadasPorAlimentacao(id);
        } else if (tipo.equals("cardapio")) {
            return cardapioDetalhadoService.buscarCardapioDetalhadoPorAlimentacao(id);
        } else {
            return new PlanoDiarioResponse();
        }
    }
}
