package br.com.iouone.dto;

import java.io.File;
import java.time.LocalDate;

public class PessoaCalculoDTO {
    private Long id;
    private String nome;
    private String email;
    private String celular;
    private String cpf;
    private LocalDate dataNascimento;

    private String atividadeFisica;
    private Float altura;
    private double pesoAtual;
    private double pesoIdeal;

    private String objetivo;
    private String biotipo;

    private String tdee;
    private String caloriasDiarias;

    public PessoaCalculoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public double getPesoAtual() {
        return pesoAtual;
    }

    public void setPesoAtual(double pesoAtual) {
        this.pesoAtual = pesoAtual;
    }

    public double getPesoIdeal() {
        return pesoIdeal;
    }

    public void setPesoIdeal(double pesoIdeal) {
        this.pesoIdeal = pesoIdeal;
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

    public String getTdee() {
        return tdee;
    }

    public void setTdee(String tdee) {
        this.tdee = tdee;
    }

    public String getCaloriasDiarias() {
        return caloriasDiarias;
    }

    public void setCaloriasDiarias(String caloriasDiarias) {
        this.caloriasDiarias = caloriasDiarias;
    }
}
