package br.com.iouone.dto;

public class PessoaDTO {
    private Integer id;
    private String name;
    private String email;
    private String document;
    private String type;
    private String gender;
    private String birthdate;
    private String celular;

    public PessoaDTO() {
    }

    public PessoaDTO(String name, String email, String document, String type, String gender, String birthdate, String celular) {
        this.name = name;
        this.email = email;
        this.document = document;
        this.type = type;
        this.gender = gender;
        this.birthdate = birthdate;
        this.celular = celular;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
