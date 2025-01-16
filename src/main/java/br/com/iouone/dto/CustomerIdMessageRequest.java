package br.com.iouone.dto;

public class CustomerIdMessageRequest {
    private Integer pessoaId;
    private String customerId;

    public CustomerIdMessageRequest() {}

    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}

