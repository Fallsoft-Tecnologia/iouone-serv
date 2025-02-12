package br.com.iouone.dto;

public class ItensDietaDetalhadaDTO {

    private String refeicao;
    private String descricao;

    public ItensDietaDetalhadaDTO() {
    }

    public ItensDietaDetalhadaDTO(String refeicao, String descricao) {
        this.refeicao = refeicao;
        this.descricao = descricao;
    }

    public String getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(String refeicao) {
        this.refeicao = refeicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
