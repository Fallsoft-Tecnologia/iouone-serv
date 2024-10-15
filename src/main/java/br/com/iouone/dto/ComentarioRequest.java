package br.com.iouone.dto;

public class ComentarioRequest {
    private Integer idComentarioPai;
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
