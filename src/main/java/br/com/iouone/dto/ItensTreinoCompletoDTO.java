package br.com.iouone.dto;

import java.util.List;

public class ItensTreinoCompletoDTO {

    private String tipoTreino;
    private List<String> treinoCompleto;

    public ItensTreinoCompletoDTO() {
    }

    public ItensTreinoCompletoDTO(String tipoTreino, List<String> treinoCompleto) {
        this.tipoTreino = tipoTreino;
        this.treinoCompleto = treinoCompleto;
    }

    public String getTipoTreino() {
        return tipoTreino;
    }

    public void setTipoTreino(String tipoTreino) {
        this.tipoTreino = tipoTreino;
    }

    public List<String> getTreinoCompleto() {
        return treinoCompleto;
    }

    public void setTreinoCompleto(List<String> treinoCompleto) {
        this.treinoCompleto = treinoCompleto;
    }
}
