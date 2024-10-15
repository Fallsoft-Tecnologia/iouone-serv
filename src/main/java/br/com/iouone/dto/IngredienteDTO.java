package br.com.iouone.dto;

public class IngredienteDTO {
    private String nome;
    private Integer quantidade;
    private String unidadeDeMedida;
    private Integer marmitaFitId;

    public IngredienteDTO() {
    }

    public IngredienteDTO(String nome, Integer quantidade, String unidadeDeMedida, Integer marmitaFitId) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.unidadeDeMedida = unidadeDeMedida;
        this.marmitaFitId = marmitaFitId;
    }

    public IngredienteDTO(String nome, Integer quantidade, String unidadeDeMedida) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(String unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public Integer getMarmitaFitId() {
        return marmitaFitId;
    }

    public void setMarmitaFitId(Integer marmitaFitId) {
        this.marmitaFitId = marmitaFitId;
    }
}
