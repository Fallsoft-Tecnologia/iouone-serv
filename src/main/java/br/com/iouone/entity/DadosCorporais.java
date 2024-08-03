package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_dados_corporais")
public class DadosCorporais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "altura")
    private Integer altura;
    @Column(name = "peso_atual")
    private Integer pesoAtual;
    @Column(name = "peso_ideal")
    private Integer pesoIdeal;

    @ManyToOne
    @JoinColumn(name = "fk_pessoa")
    private Pessoa pessoa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getPesoAtual() {
        return pesoAtual;
    }

    public void setPesoAtual(Integer pesoAtual) {
        this.pesoAtual = pesoAtual;
    }

    public Integer getPesoIdeal() {
        return pesoIdeal;
    }

    public void setPesoIdeal(Integer pesoIdeal) {
        this.pesoIdeal = pesoIdeal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
