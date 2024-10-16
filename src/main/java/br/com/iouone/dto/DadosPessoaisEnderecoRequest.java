package br.com.iouone.dto;

public class DadosPessoaisEnderecoRequest {

    private Integer idPessoa;
    private String cep;
    private String endereco;
    private String cidade;
    private String estado;
    private PaisesRequest pais;

    public DadosPessoaisEnderecoRequest() {
    }

    public DadosPessoaisEnderecoRequest(Integer idPessoa, String cep, String endereco, String cidade, String estado, PaisesRequest pais) {
        this.idPessoa = idPessoa;
        this.cep = cep;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PaisesRequest getPais() {
        return pais;
    }

    public void setPais(PaisesRequest pais) {
        this.pais = pais;
    }
}
