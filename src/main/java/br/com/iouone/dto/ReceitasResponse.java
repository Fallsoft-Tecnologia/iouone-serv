package br.com.iouone.dto;

import java.util.List;

public class ReceitasResponse {

    private String titulo;
    private String descricao;
    private List<String> ingredientes;
    private PreparoReceitasDTO preparo;

    public ReceitasResponse() {
    }

    public ReceitasResponse(String titulo, String descricao, List<String> ingredientes, PreparoReceitasDTO preparo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.ingredientes = ingredientes;
        this.preparo = preparo;
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

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public PreparoReceitasDTO getPreparo() {
        return preparo;
    }

    public void setPreparo(PreparoReceitasDTO preparo) {
        this.preparo = preparo;
    }
}
