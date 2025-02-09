package br.com.iouone.dto;

public class DietaDetalhadaDTO {

    private String titulo;
    private String descricao;
    private String alimentacaoDiaria;
    private String dieta;

    public DietaDetalhadaDTO() {
    }

    public DietaDetalhadaDTO(String titulo, String descricao, String alimentacaoDiaria, String dieta) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.alimentacaoDiaria = alimentacaoDiaria;
        this.dieta = dieta;
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

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }
}
