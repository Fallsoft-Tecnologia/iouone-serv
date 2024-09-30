package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "receita_cha_gordura")
public class ReceitaChaGordura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float quantidade;

    @Column(name = "id_ingredientes")
    private Integer idIngredientes;

    @Column(name = "id_cha_gordura")
    private Integer idChaGordura;

    @Column(name = "id_unidade_de_medida")
    private Integer idUnidadeDeMedida;

    public ReceitaChaGordura() {
    }

    public ReceitaChaGordura(Integer id, Float quantidade, Integer idIngredientes, Integer idChaGordura, Integer idUnidadeDeMedida) {
        this.id = id;
        this.quantidade = quantidade;
        this.idIngredientes = idIngredientes;
        this.idChaGordura = idChaGordura;
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

    public Integer getIdChaGordura() {
        return idChaGordura;
    }

    public void setIdChaGordura(Integer idChaGordura) {
        this.idChaGordura = idChaGordura;
    }

    public Integer getIdUnidadeDeMedida() {
        return idUnidadeDeMedida;
    }

    public void setIdUnidadeDeMedida(Integer idUnidadeDeMedida) {
        this.idUnidadeDeMedida = idUnidadeDeMedida;
    }
}
