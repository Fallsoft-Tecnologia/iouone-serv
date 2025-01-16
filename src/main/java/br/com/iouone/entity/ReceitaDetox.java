package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "receita_detox")
public class ReceitaDetox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantidadade")
    private Float quantidade;

    @Column(name = "id_ingredientes")
    private Integer idIngredientes;

    @Column(name = "id_detox")
    private Integer idDetox;

    @Column(name = "id_unidade_de_medida")
    private Integer idUnidadeDeMedida;

    public ReceitaDetox() {
    }

    public ReceitaDetox(Integer id, Float quantidade, Integer idIngredientes, Integer idDetox, Integer idUnidadeDeMedida) {
        this.id = id;
        this.quantidade = quantidade;
        this.idIngredientes = idIngredientes;
        this.idDetox = idDetox;
        this.idUnidadeDeMedida = idUnidadeDeMedida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getIdIngredientes() {
        return idIngredientes;
    }

    public void setIdIngredientes(Integer idIngredientes) {
        this.idIngredientes = idIngredientes;
    }

    public Integer getIdDetox() {
        return idDetox;
    }

    public void setIdDetox(Integer idDetox) {
        this.idDetox = idDetox;
    }

    public Integer getIdUnidadeDeMedida() {
        return idUnidadeDeMedida;
    }

    public void setIdUnidadeDeMedida(Integer idUnidadeDeMedida) {
        this.idUnidadeDeMedida = idUnidadeDeMedida;
    }
}
