package br.com.iouone.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
    @Column(name = "celular")
    private String celular;
    @Column(name = "dt_nascimento")
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "fk_atividade_fisica")
    private AtividadeFisica atividadeFisica;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public AtividadeFisica getAtividadeFisica() {
        return atividadeFisica;
    }

    public void setAtividadeFisica(AtividadeFisica atividadeFisica) {
        this.atividadeFisica = atividadeFisica;
    }
}
