package br.com.iouone.dto;

public class TreinoCompletoDTO {


    private String titulo;
    private String descricao;
    private String tipoTreino;
    private String treino;

    public TreinoCompletoDTO() {
    }

    public TreinoCompletoDTO(String titulo, String descricao, String tipoTreino, String treino) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipoTreino = tipoTreino;
        this.treino = treino;
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

    public String getTipoTreino() {
        return tipoTreino;
    }

    public void setTipoTreino(String tipoTreino) {
        this.tipoTreino = tipoTreino;
    }

    public String getTreino() {
        return treino;
    }

    public void setTreino(String treino) {
        this.treino = treino;
    }
}
