package br.com.iouone.dto;

import jakarta.validation.constraints.NotBlank;

public class ComentarioRequest {
    private Integer idComentarioPai;
    @NotBlank(message = "A mensagem do comentário não pode estar em branco.")
    private String mensagemComentario;
    public ComentarioRequest() {}

    public Integer getIdComentarioPai() {
        return idComentarioPai;
    }

    public void setIdComentarioPai(Integer idComentarioPai) {
        this.idComentarioPai = idComentarioPai;
    }

    public String getMensagemComentario() {
        return mensagemComentario;
    }

    public void setMensagemComentario(String mensagemComentario) {
        this.mensagemComentario = mensagemComentario;
    }
}
