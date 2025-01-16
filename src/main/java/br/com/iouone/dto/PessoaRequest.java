package br.com.iouone.dto;

import java.time.LocalDate;

public class PessoaRequest {
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private String celular;
    private LocalDate dataNascimento;
    private Integer atividadeFisicaId;

    public PessoaRequest(String cpf, String nome, String email, String senha, String celular, LocalDate dataNascimento, Integer atividadeFisicaId) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.celular = celular;
        this.dataNascimento = dataNascimento;
        this.atividadeFisicaId = atividadeFisicaId;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public Integer getAtividadeFisicaId() {
        return atividadeFisicaId;
    }

    public void setAtividadeFisicaId(Integer atividadeFisicaId) {
        this.atividadeFisicaId = atividadeFisicaId;
    }
}