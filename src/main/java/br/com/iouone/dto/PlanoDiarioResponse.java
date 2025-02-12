package br.com.iouone.dto;

import java.util.List;

public class PlanoDiarioResponse {


    private String titulo;
    private String descricao;
    private List<ItensDietaDetalhadaDTO> itens;

    public PlanoDiarioResponse() {
    }

    public PlanoDiarioResponse(String titulo, String descricao, List<ItensDietaDetalhadaDTO> itens) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.itens = itens;
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ItensDietaDetalhadaDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItensDietaDetalhadaDTO> itens) {
        this.itens = itens;
    }
}
