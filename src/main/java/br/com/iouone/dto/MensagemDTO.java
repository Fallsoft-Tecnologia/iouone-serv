package br.com.iouone.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MensagemDTO {
    private int id;
    @NotBlank(message = "A mensagem não pode ser vazia.")
    private String mensagem;
    @NotNull(message = "A data de envio não pode ser nula.")
    private LocalDateTime dataEnvio;
    @NotBlank(message = "O nome da pessoa é obrigatório.")
    private String nomePessoa;

    public MensagemDTO(int id, String mensagem, LocalDateTime dataEnvio, String nomePessoa) {
        this.id = id;
        this.mensagem = mensagem;
        this.dataEnvio = dataEnvio;
        this.nomePessoa = nomePessoa;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }
}
