package br.com.iouone.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class CadastroCompletoDTO {
    @NotNull(message = "Os dados de login são obrigatórios.")
    @Valid
    private LoginDTO login;
    @NotNull(message = "Os dados pessoais são obrigatórios.")
    @Valid
    private DadosPessoaisPessoaRequest dadosPessoais;
    @NotNull(message = "O endereço é obrigatório.")
    @Valid
    private DadosPessoaisEnderecoRequest endereco;
    @NotNull(message = "Os dados corporais são obrigatórios.")
    @Valid
    private DadosPessoaisCorporaisRequest corporais;

    public LoginDTO getLogin() {
        return login;
    }

    public void setLogin(LoginDTO login) {
        this.login = login;
    }

    public DadosPessoaisPessoaRequest getDadosPessoais() {
        return dadosPessoais;
    }

    public void setDadosPessoais(DadosPessoaisPessoaRequest dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public DadosPessoaisEnderecoRequest getEndereco() {
        return endereco;
    }

    public void setEndereco(DadosPessoaisEnderecoRequest endereco) {
        this.endereco = endereco;
    }

    public DadosPessoaisCorporaisRequest getCorporais() {
        return corporais;
    }

    public void setCorporais(DadosPessoaisCorporaisRequest corporais) {
        this.corporais = corporais;
    }
}
