package br.com.iouone.dto;

import java.time.LocalDate;
import java.time.Period;

public class DadosPessoaTDEEDTO {

    private String altura;
    private String peso;
    private String idade;
    private Double taxaMetabolica;
    private String nivelAtividadeFisica;
    private Double tdee;
    private String objetivo;
    private String biotipo;


    public DadosPessoaTDEEDTO(Float altura, Float peso, LocalDate dataNascimento, Double taxaMetabolica, String nivelAtividadeFisica, Double tdee, String objetivo, String biotipo) {
        this.altura = altura != null ? altura.toString().replace(".0", "") : null;
        this.peso = peso != null ? peso.toString().replace(".0", "") : null;
        this.idade = dataNascimento != null ? String.valueOf(calcularIdade(dataNascimento)) : null;
        this.taxaMetabolica = taxaMetabolica;
        this.nivelAtividadeFisica = nivelAtividadeFisica;
        this.tdee = tdee;
        this.objetivo = objetivo;
        this.biotipo = biotipo;
    }

    public DadosPessoaTDEEDTO(Float altura, LocalDate dataNascimento, String nivelAtividadeFisica, Float peso) {
        this.altura = altura != null ? altura.toString().replace(".0", "") : null;
        this.idade = dataNascimento != null ? String.valueOf(calcularIdade(dataNascimento)) : null;
        this.nivelAtividadeFisica = nivelAtividadeFisica;
        this.peso = peso != null ? peso.toString().replace(".0", "") : null;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getNivelAtividadeFisica() {
        return nivelAtividadeFisica;
    }

    public void setNivelAtividadeFisica(String nivelAtividadeFisica) {
        this.nivelAtividadeFisica = nivelAtividadeFisica;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public Double getTaxaMetabolica() {
        return taxaMetabolica;
    }

    public void setTaxaMetabolica(Double taxaMetabolica) {
        this.taxaMetabolica = taxaMetabolica;
    }

    public Double getTdee() {
        return tdee;
    }

    public void setTdee(Double tdee) {
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

    private static int calcularIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

}
