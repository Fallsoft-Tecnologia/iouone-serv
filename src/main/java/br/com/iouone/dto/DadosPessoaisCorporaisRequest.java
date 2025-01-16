package br.com.iouone.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DadosPessoaisCorporaisRequest {

    @NotNull(message = "O peso ideal não pode ser nulo.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O peso ideal deve ser maior que zero.")
    private Float pesoIdeal;
    @NotNull(message = "A altura não pode ser nula.")
    @DecimalMin(value = "0.0", inclusive = false, message = "A altura deve ser maior que zero.")
    private Float altura;
    @NotNull(message = "O peso atual não pode ser nulo.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O peso atual deve ser maior que zero.")
    private Float pesoAtual;
    @NotBlank(message = "A atividade física não pode estar em branco.")
    private String atividadeFisica;

    public Float getPesoIdeal() {
        return pesoIdeal;
    }

    public void setPesoIdeal(Float pesoIdeal) {
        this.pesoIdeal = pesoIdeal;
    }

    public String getAtividadeFisica() {
        return atividadeFisica;
    }

    public void setAtividadeFisica(String atividadeFisica) {
        this.atividadeFisica = atividadeFisica;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Float getPesoAtual() {
        return pesoAtual;
    }

    public void setPesoAtual(Float pesoAtual) {
        this.pesoAtual = pesoAtual;
    }
}
