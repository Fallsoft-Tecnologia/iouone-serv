package br.com.iouone.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class DadosPessoaisPessoaRequest {

    @NotBlank(message = "O nome não pode estar em branco.")
    @Size(max = 100, message = "O nome não pode ter mais de 100 caracteres.")
    private String nome;
    @NotNull(message = "A data de nascimento é obrigatória.")
    @Past(message = "A data de nascimento deve ser uma data no passado.")
    private LocalDate dataNascimento;
    @NotBlank(message = "O número de celular não pode estar em branco.")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "O celular deve estar no formato (XX) XXXXX-XXXX.")
    private String celular;


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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
