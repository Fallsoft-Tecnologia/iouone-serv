package br.com.iouone.dto;

import java.time.LocalDate;

public class DadosPessoaisPessoaRequest {

    private Integer idPessoa;
    private String nome;
    private LocalDate dataNascimento;
    private String telefone;
    private String cpf;

    public DadosPessoaisPessoaRequest() {
    }

    public DadosPessoaisPessoaRequest(Integer idPessoa, String nome, LocalDate dataNascimento, String telefone, String cpf) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
