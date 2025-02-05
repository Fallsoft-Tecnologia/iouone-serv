package br.com.iouone.dto;

public class CriarCalculoRequestDTO {
    private String objetivo;
    private String biotipo;
    private String altura;
    private String peso;
    private String nivelAtividadeFisica;
    private String taxaMetabolica;
    private String tdee;

    public CriarCalculoRequestDTO() {
    }

    public CriarCalculoRequestDTO(String objetivo, String biotipo, String altura, String peso, String nivelAtividadeFisica, String taxaMetabolica, String tdee) {
        this.objetivo = objetivo;
        this.biotipo = biotipo;
        this.altura = altura;
        this.peso = peso;
        this.nivelAtividadeFisica = nivelAtividadeFisica;
        this.taxaMetabolica = taxaMetabolica;
        this.tdee = tdee;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getBiotipo() {
        return biotipo;
    }

    public void setBiotipo(String biotipo) {
        this.biotipo = biotipo;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getNivelAtividadeFisica() {
        return nivelAtividadeFisica;
    }

    public String getTaxaMetabolica() {
        return taxaMetabolica;
    }

    public void setTaxaMetabolica(String taxaMetabolica) {
        this.taxaMetabolica = taxaMetabolica;
    }

    public String getTdee() {
        return tdee;
    }

    public void setTdee(String tdee) {
        this.tdee = tdee;
    }

    public void setNivelAtividadeFisica(String nivelAtividadeFisica) {
        this.nivelAtividadeFisica = nivelAtividadeFisica;


    }
}