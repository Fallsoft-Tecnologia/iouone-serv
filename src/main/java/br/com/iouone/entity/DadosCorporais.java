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
    private Float altura;
    @Column(name = "peso_atual")
    private Float pesoAtual;
    @Column(name = "peso_ideal")
    private Float pesoIdeal;

    public DadosCorporais() {
    }

    public DadosCorporais(int id, Float altura, Float pesoAtual, Float pesoIdeal) {
        this.id = id;
        this.altura = altura;
        this.pesoAtual = pesoAtual;
        this.pesoIdeal = pesoIdeal;
    }

    public DadosCorporais(Float altura, Float pesoAtual,Float pesoIdeal) {
        this.altura = altura;
        this.pesoAtual = pesoAtual;
        this.pesoIdeal = pesoIdeal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Float getPesoAtual() {
        return pesoAtual;
    }

    public void setPesoAtual(Float pesoAtual) {
        this.pesoAtual = pesoAtual;
    }

    public Float getPesoIdeal() {
        return pesoIdeal;
    }

    public void setPesoIdeal(Float pesoIdeal) {
        this.pesoIdeal = pesoIdeal;
    }
}
