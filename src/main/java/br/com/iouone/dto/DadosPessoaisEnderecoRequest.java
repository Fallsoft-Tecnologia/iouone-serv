package br.com.iouone.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DadosPessoaisEnderecoRequest {

    @NotBlank(message = "O CEP não pode estar em branco.")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato 00000-000.")
    private String cep;
    @NotBlank(message = "O endereço não pode estar em branco.")
    @Size(max = 255, message = "O endereço não pode ter mais de 255 caracteres.")
    private String endereco;
    @NotBlank(message = "A cidade não pode estar em branco.")
    @Size(max = 100, message = "A cidade não pode ter mais de 100 caracteres.")
    private String cidade;
    @NotBlank(message = "O estado não pode estar em branco.")
    @Size(max = 100, message = "O estado não pode ter mais de 100 caracteres.")
    private String estado;
    @NotBlank(message = "O país não pode estar em branco.")
    @Size(max = 100, message = "O país não pode ter mais de 100 caracteres.")
    private String pais;

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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
