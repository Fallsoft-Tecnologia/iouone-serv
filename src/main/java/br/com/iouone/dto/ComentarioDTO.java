package br.com.iouone.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComentarioDTO {
    private int id;
    private String mensagemComentario;
    private int fkMensagemInicial;
    private Integer fkComentarioPai;
    private LocalDateTime dataEnvio;
    private String nomeCliente;

    public ComentarioDTO() {
    }

    public ComentarioDTO(int id, String mensagemComentario, int fkMensagemInicial, Integer fkComentarioPai, LocalDateTime dataEnvio, String nomeCliente) {
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

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
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
