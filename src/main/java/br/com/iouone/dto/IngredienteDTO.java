package br.com.iouone.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class IngredienteDTO {
    @NotBlank(message = "O nome do ingrediente não pode estar em branco.")
    @Size(max = 100, message = "O nome do ingrediente não pode ter mais de 100 caracteres.")
    private String nome;
    @NotNull(message = "A quantidade do ingrediente é obrigatória.")
    @Min(value = 1, message = "A quantidade do ingrediente deve ser maior que zero.")
    private Integer quantidade;
    @NotBlank(message = "A unidade de medida não pode estar em branco.")
    @Size(max = 10, message = "A unidade de medida não pode ter mais de 10 caracteres.")
    private String unidadeDeMedida;
    @NotNull(message = "O ID da marmita é obrigatório.")
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
