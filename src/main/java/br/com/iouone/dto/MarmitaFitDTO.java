package br.com.iouone.dto;

import java.util.List;

public class MarmitaFitDTO {

    private String nome;
    private String modoDePreparo;
    private String foto;
    private String descricao;
    private List<IngredienteDTO> ingredientes;

    public MarmitaFitDTO() {}

    public MarmitaFitDTO(String nome, String modoDePreparo, String foto, String descricao, List<IngredienteDTO> ingredientes) {
        this.nome = nome;
        this.modoDePreparo = modoDePreparo;
        this.foto = foto;
        this.descricao = descricao;
        this.ingredientes = ingredientes;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModoDePreparo() {
        return modoDePreparo;
    }

    public void setModoDePreparo(String modoDePreparo) {
        this.modoDePreparo = modoDePreparo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<IngredienteDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
