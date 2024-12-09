package br.com.iouone.dto;

public class DadosPessoaisCorporaisRequest {

    private Float pesoIdeal;
    private Float altura;
    private Float pesoAtual;
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
