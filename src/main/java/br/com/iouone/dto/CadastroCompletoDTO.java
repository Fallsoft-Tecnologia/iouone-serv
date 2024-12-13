package br.com.iouone.dto;

public class CadastroCompletoDTO {
    private LoginDTO login;
    private DadosPessoaisPessoaRequest dadosPessoais;
    private DadosPessoaisEnderecoRequest endereco;
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
