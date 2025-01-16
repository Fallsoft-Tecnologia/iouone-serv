package br.com.iouone.dto;

public class CriarCalculoRequestDTO {
    private int pessoaId;
    private int objetivoId;
    private int biotipoId;
    private String dataCalculo;

    public CriarCalculoRequestDTO() {
    }

    public CriarCalculoRequestDTO(int pessoaId, int objetivoId, int biotipoId, String dataCalculo) {
        this.pessoaId = pessoaId;
        this.objetivoId = objetivoId;
        this.biotipoId = biotipoId;
        this.dataCalculo = dataCalculo;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    public int getObjetivoId() {
        return objetivoId;
    }

    public void setObjetivoId(int objetivoId) {
        this.objetivoId = objetivoId;
    }

    public int getBiotipoId() {
        return biotipoId;
    }

    public void setBiotipoId(int biotipoId) {
        this.biotipoId = biotipoId;
    }

    public String getDataCalculo() {
        return dataCalculo;
    }

    public void setDataCalculo(String dataCalculo) {
        this.dataCalculo = dataCalculo;
    }
}