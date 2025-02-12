package br.com.iouone.mapper;

import br.com.iouone.dto.PreparoReceitasDTO;
import br.com.iouone.dto.ReceitasDTO;
import br.com.iouone.dto.ReceitasResponse;
import br.com.iouone.util.StringUtil;

import java.util.List;

public class ReceitasMapper {

    public static ReceitasResponse receitasDtotoResponse(ReceitasDTO receitasDTO) {
        String titulo = receitasDTO.getTitulo();
        String descricao = receitasDTO.getDescricao();
        List<String> ingredientes = StringUtil.dividirStringReturnList(receitasDTO.getIngredientes());
        List<String> modoPreparo = StringUtil.dividirStringReturnList(receitasDTO.getPreparo());

        return new ReceitasResponse(titulo, descricao, ingredientes, new PreparoReceitasDTO(modoPreparo));
    }
}
