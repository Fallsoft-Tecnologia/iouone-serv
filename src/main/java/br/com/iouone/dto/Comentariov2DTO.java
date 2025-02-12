package br.com.iouone.dto;

import java.time.LocalDateTime;

public class Comentariov2DTO {
    private int id;
    private String mensagemComentario;
    private String nomeCliente;

    public Comentariov2DTO() {
    }

    public Comentariov2DTO(int id, String mensagemComentario, String nomeCliente) {
        this.id = id;
        this.mensagemComentario = mensagemComentario;
        this.nomeCliente = nomeCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
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


}
