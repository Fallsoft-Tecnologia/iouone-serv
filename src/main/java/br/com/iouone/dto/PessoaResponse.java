package br.com.iouone.dto;

import java.time.LocalDate;

public class PessoaResponse {
    private Integer id;
    private String cpf;
    private String nome;
    private String email;
    private String celular;
    private LocalDate dataNascimento;
    private String cep;
    private String endereco;
    private String cidade;
    private String estado;
    private String pais;
    private Float pesoIdeal;
    private String atividadeFisica;
    private Float altura;
    private Float pesoAtual;

    public PessoaResponse() {
    }

    public PessoaResponse(Integer id, String cpf, String nome, String email, String celular, LocalDate dataNascimento, String atividadeFisica) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.dataNascimento = dataNascimento;
        this.atividadeFisica = atividadeFisica;
    }

    public PessoaResponse(Integer id, String cpf, String nome, String email, String celular, LocalDate dataNascimento, String cep, String endereco, String cidade, String estado, String pais, Float pesoIdeal, String atividadeFisica, Float altura, Float pesoAtual) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.pesoIdeal = pesoIdeal;
        this.atividadeFisica = atividadeFisica;
        this.altura = altura;
        this.pesoAtual = pesoAtual;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getCep() {return cep; }

    public void setCep(String cep) {this.cep = cep; }

    public String getEndereco() {return endereco; }

    public void setEndereco(String endereco) {this.endereco = endereco; }

    public String getCidade() {return cidade; }

    public void setCidade(String cidade) {this.cidade = cidade; }

    public String getEstado() {return estado; }

    public void setEstado(String estado) {this.estado = estado; }

    public String getPais() {return pais; }

    public void setPais(String pais) {this.pais = pais; }

    public Float getPesoIdeal() {return pesoIdeal; }

    public void setPesoIdeal(Float pesoIdeal) {this.pesoIdeal = pesoIdeal; }

    public Float getAltura() {return altura; }

    public void setAltura(Float altura) {this.altura = altura; }

    public Float getPesoAtual() {return pesoAtual; }

    public void setPesoAtual(Float pesoAtual) {this.pesoAtual = pesoAtual; }
}