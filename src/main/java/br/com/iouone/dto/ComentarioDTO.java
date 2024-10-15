package br.com.iouone.dto;

import java.time.LocalDate;

public class ComentarioDTO {
    private int id;
    private String mensagemComentario;
    private int fkMensagemInicial;
    private Integer fkComentarioPai;
    private LocalDate dataEnvio;
    private String nomeCliente;

    public ComentarioDTO() {
    }

    public ComentarioDTO(int id, String mensagemComentario, int fkMensagemInicial, Integer fkComentarioPai, LocalDate dataEnvio, String nomeCliente) {
        this.id = id;
        this.mensagemComentario = mensagemComentario;
        this.fkMensagemInicial = fkMensagemInicial;
        this.fkComentarioPai = fkComentarioPai;
        this.dataEnvio = dataEnvio;
        this.nomeCliente = nomeCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensagemComentario() {
        return mensagemComentario;
    }

    public void setMensagemComentario(String mensagemComentario) {
        this.mensagemComentario = mensagemComentario;
    }

    public int getFkMensagemInicial() {
        return fkMensagemInicial;
    }

    public void setFkMensagemInicial(int fkMensagemInicial) {
        this.fkMensagemInicial = fkMensagemInicial;
    }

    public Integer getFkComentarioPai() {
        return fkComentarioPai;
    }

    public void setFkComentarioPai(Integer fkComentarioPai) {
        this.fkComentarioPai = fkComentarioPai;
    }
}
