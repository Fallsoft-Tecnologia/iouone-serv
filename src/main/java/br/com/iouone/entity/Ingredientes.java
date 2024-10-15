package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredientes")
public class Ingredientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Integer quantidade;

    @Column(name = "unidade_medida_id")
    private Integer unidadeMedidaId;

    @Column(name = "marmita_fit_id")
    private Integer marmitaFitId;
    public Ingredientes() {
    }

    public Ingredientes(Integer id, String nome, Integer quantidade, Integer unidadeMedidaId, Integer marmitaFitId) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.unidadeMedidaId = unidadeMedidaId;
        this.marmitaFitId = marmitaFitId;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getUnidadeMedidaId() {
        return unidadeMedidaId;
    }

    public void setUnidadeMedidaId(Integer unidadeMedidaId) {
        this.unidadeMedidaId = unidadeMedidaId;
    }

    public Integer getMarmitaFitId() {
        return marmitaFitId;
    }

    public void setMarmitaFitId(Integer marmitaFitId) {
        this.marmitaFitId = marmitaFitId;
    }
}
