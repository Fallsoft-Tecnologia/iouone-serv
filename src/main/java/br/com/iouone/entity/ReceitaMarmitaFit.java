package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "receita_marmita_fit")
public class ReceitaMarmitaFit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantidade;

    @Column(name = "id_marmita_fit")
    private Integer idMarmitaFit;

    @Column(name = "id_ingredientes")
    private Integer idIngredientes;

    @Column(name = "id_unidade_de_medida")
    private Integer idUnidadeDeMedida;

    public ReceitaMarmitaFit() {
    }

    public ReceitaMarmitaFit(Integer id, Integer quantidade, Integer idMarmitaFit, Integer idIngredientes, Integer idUnidadeDeMedida) {

        this.id = id;
        this.quantidade = quantidade;
        this.idMarmitaFit = idMarmitaFit;
        this.idIngredientes = idIngredientes;
        this.idUnidadeDeMedida = idUnidadeDeMedida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getIdMarmitaFit() {
        return idMarmitaFit;
    }

    public void setIdMarmitaFit(Integer idMarmitaFit) {
        this.idMarmitaFit = idMarmitaFit;
    }

    public Integer getIdIngredientes() {
        return idIngredientes;
    }

    public void setIdIngredientes(Integer idIngredientes) {
        this.idIngredientes = idIngredientes;
    }

    public Integer getIdUnidadeDeMedida() {
        return idUnidadeDeMedida;
    }

    public void setIdUnidadeDeMedida(Integer idUnidadeDeMedida) {
        this.idUnidadeDeMedida = idUnidadeDeMedida;
    }
}
