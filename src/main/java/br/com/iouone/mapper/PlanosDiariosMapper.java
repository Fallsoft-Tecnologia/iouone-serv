package br.com.iouone.mapper;

import br.com.iouone.dto.ItensDietaDetalhadaDTO;
import br.com.iouone.dto.PlanoDiarioDTO;
import br.com.iouone.dto.PlanoDiarioResponse;

import java.util.ArrayList;
import java.util.List;

public class PlanosDiariosMapper {

    public static PlanoDiarioResponse dtoToPlanoDiarioResponse(List<PlanoDiarioDTO> dados) {
        PlanoDiarioResponse planoDiarioResponse = new PlanoDiarioResponse();
        List<ItensDietaDetalhadaDTO> itens = new ArrayList<>();

        dados.forEach(x -> {
            if (planoDiarioResponse.getTitulo() == null) {
                planoDiarioResponse.setTitulo(x.getTitulo());
            }
            if (planoDiarioResponse.getDescricao() == null) {
                planoDiarioResponse.setDescricao(x.getDescricao());
            }

            itens.add(new ItensDietaDetalhadaDTO(x.getAlimentacaoDiaria(), x.getDescricaoAlimentacaoDiaria().replaceAll("\n", "").trim()));
            planoDiarioResponse.setItens(itens);
        });

        return planoDiarioResponse;
    }
}
