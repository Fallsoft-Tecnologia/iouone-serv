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

    public PessoaRequest(String nome, String mail, String senha123, String number, String number1, LocalDate now, int i) {
    }

    // Getters e Setters
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