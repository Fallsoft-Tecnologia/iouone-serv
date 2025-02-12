package br.com.iouone.dto;

public class PlanoDiarioDTO {

    private String titulo;
    private String descricao;
    private String alimentacaoDiaria;
    private String descricaoAlimentacaoDiaria;

    public PlanoDiarioDTO() {
    }

    public PlanoDiarioDTO(String titulo, String descricao, String alimentacaoDiaria, String descricaoAlimentacaoDiaria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.alimentacaoDiaria = alimentacaoDiaria;
        this.descricaoAlimentacaoDiaria = descricaoAlimentacaoDiaria;
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

    public String getAlimentacaoDiaria() {
        return alimentacaoDiaria;
    }

    public void setAlimentacaoDiaria(String alimentacaoDiaria) {
        this.alimentacaoDiaria = alimentacaoDiaria;
    }

    public String getDescricaoAlimentacaoDiaria() {
        return descricaoAlimentacaoDiaria;
    }

    public void setDescricaoAlimentacaoDiaria(String descricaoAlimentacaoDiaria) {
        this.descricaoAlimentacaoDiaria = descricaoAlimentacaoDiaria;
    }
}
