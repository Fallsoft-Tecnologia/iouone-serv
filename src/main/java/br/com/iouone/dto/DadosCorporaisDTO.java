package br.com.iouone.dto;

public class DadosCorporaisDTO {
    private Integer id;
    private Float altura;
    private Float pesoAtual;
    private Float pesoIdeal;

    public DadosCorporaisDTO(Integer id, Float altura, Float pesoAtual, Float pesoIdeal) {
        this.id = id;
        this.altura = altura;
        this.pesoAtual = pesoAtual;
        this.pesoIdeal = pesoIdeal;
    }

    public Integer getId() { return id; }
    public Float getAltura() { return altura; }
    public Float getPesoAtual() { return pesoAtual; }
    public Float getPesoIdeal() { return pesoIdeal; }
}
