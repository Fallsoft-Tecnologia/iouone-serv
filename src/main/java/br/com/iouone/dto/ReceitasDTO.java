package br.com.iouone.dto;

import java.util.List;

public class ReceitasDTO {

    private String titulo;
    private String descricao;
    private String ingredientes;
    private String preparo;

    public ReceitasDTO() {
    }

    public ReceitasDTO(String titulo, String descricao, String ingredientes, String preparo) {
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

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparo() {
        return preparo;
    }

    public void setPreparo(String preparo) {
        this.preparo = preparo;
    }
}
