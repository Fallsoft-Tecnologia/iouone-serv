package br.com.iouone.dto;

public class DadosEnderecoPessoaDTO {

    private String endereco;
    private String estado;
    private String pais;
    private String cidade;
    private String cep;
    private String customerId;

    public DadosEnderecoPessoaDTO() {
    }

    public DadosEnderecoPessoaDTO(String endereco, String estado, String pais, String cidade, String cep, String customerId) {
        this.endereco = endereco;
        this.estado = estado;
        this.pais = pais;
        this.cidade = cidade;
        this.cep = cep;
        this.customerId = customerId;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
