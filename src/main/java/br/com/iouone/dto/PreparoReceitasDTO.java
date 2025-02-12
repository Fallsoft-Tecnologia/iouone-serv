package br.com.iouone.dto;

import java.util.List;

public class PreparoReceitasDTO {
    private List<String> descricao;

    public PreparoReceitasDTO() {
    }

    public PreparoReceitasDTO(List<String> descricao) {
        this.descricao = descricao;
    }

    public List<String> getDescricao() {
        return descricao;
    }

    public void setDescricao(List<String> descricao) {
        this.descricao = descricao;
    }
}
