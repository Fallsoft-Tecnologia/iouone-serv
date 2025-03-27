package br.com.iouone.mapper;

import br.com.iouone.dto.*;
import br.com.iouone.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class TreinosMapper {

    public static TreinoCompletoResponse dtoToTreinoCompletoResponse(List<TreinoCompletoDTO> dados) {
        TreinoCompletoResponse treinoCompletoResponse = new TreinoCompletoResponse();
        List<ItensTreinoCompletoDTO> itens = new ArrayList<>();

        dados.forEach(x -> {
            if (treinoCompletoResponse.getTitulo() == null) {
                treinoCompletoResponse.setTitulo(x.getTitulo());
            }
            if (treinoCompletoResponse.getDescricao() == null) {
                treinoCompletoResponse.setDescricao(x.getDescricao());
            }

            itens.add(new ItensTreinoCompletoDTO(x.getTipoTreino(), StringUtil.dividirStringReturnListVirgula(x.getTreino())));
            treinoCompletoResponse.setItens(itens);
        });

        return treinoCompletoResponse;
    }
}
