package br.com.iouone.entity;

import br.com.iouone.dto.LoginRequest;
import jakarta.persistence.*;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    @Column(name = "customer_id")
    private String customerId;
    @Column(name="fluxo_id")
    private String fluxoId;

    @ManyToOne
    @JoinColumn(name = "fk_atividade_fisica")
    private AtividadeFisica atividadeFisica;

    @ManyToOne
    @JoinColumn(name = "fk_endereco")
    private Endereco endereco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_dados_corporais")
    private DadosCorporais dadosCorporais;


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

    public String getFluxoId() {
        return fluxoId;
    }

    public void setFluxoId(String fluxoId) {
        this.fluxoId = fluxoId;
    }

    public AtividadeFisica getAtividadeFisica() {
        return atividadeFisica;
    }

    public void setAtividadeFisica(AtividadeFisica atividadeFisica) {
        this.atividadeFisica = atividadeFisica;
    }

    public boolean isLoginCorrect(LoginRequest loginRequest, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(loginRequest.getPassword(), this.senha);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public DadosCorporais getDadosCorporais() {
        return dadosCorporais;
    }

    public void setDadosCorporais(DadosCorporais dadosCorporais) {
        this.dadosCorporais = dadosCorporais;
    }
}
