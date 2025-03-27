package br.com.iouone.dto;

import java.util.List;

public class TreinoCompletoResponse {

    private String titulo;
    private String descricao;
    private List<ItensTreinoCompletoDTO> itens;

    public TreinoCompletoResponse() {
    }

    public TreinoCompletoResponse(String titulo, String descricao, List<ItensTreinoCompletoDTO> itens) {
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

    public List<ItensTreinoCompletoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItensTreinoCompletoDTO> itens) {
        this.itens = itens;
    }
}
