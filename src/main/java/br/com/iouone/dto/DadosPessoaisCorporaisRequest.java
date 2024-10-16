package br.com.iouone.dto;

public class DadosPessoaisCorporaisRequest {

    private Integer idPessoa;
    private Float pesoIdeal;
    private Float altura;
    private Float pesoAtual;
    private AtividadeFisicaRequest atividadeFisicaRequest;


    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Float getPesoIdeal() {
        return pesoIdeal;
    }

    public void setPesoIdeal(Float pesoIdeal) {
        this.pesoIdeal = pesoIdeal;
    }

    public AtividadeFisicaRequest getAtividadeFisicaRequest() {
        return atividadeFisicaRequest;
    }

    public void setAtividadeFisicaRequest(AtividadeFisicaRequest atividadeFisicaRequest) {
        this.atividadeFisicaRequest = atividadeFisicaRequest;
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
