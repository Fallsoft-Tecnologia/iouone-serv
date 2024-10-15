package br.com.iouone.dto;

import java.time.LocalDate;

public class MensagemDTO {
    private int id;
    private String mensagem;
    private LocalDate dataEnvio;
    private String nomePessoa;

    public MensagemDTO(int id, String mensagem, LocalDate dataEnvio, String nomePessoa) {
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

    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }
}
