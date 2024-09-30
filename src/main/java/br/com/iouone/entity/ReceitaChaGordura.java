package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "receita_cha_gordura")
public class ReceitaChaGordura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float quantidade;

    @ManyToOne
    @JoinColumn(name = "id_ingredientes")
    private Ingredientes ingredientes;

    @ManyToOne
    @JoinColumn(name = "id_cha_gordura")
    private ChaGordura chaGordura;

    @ManyToOne
    @JoinColumn(name = "id_unidade_de_medida")
    private UnidadeDeMedida unidadeDeMedida;

    public ReceitaChaGordura() {
    }

    public ReceitaChaGordura(Integer id, Float quantidade, Ingredientes ingredientes, ChaGordura chaGordura, UnidadeDeMedida unidadeDeMedida) {
        this.id = id;
        this.quantidade = quantidade;
        this.ingredientes = ingredientes;
        this.chaGordura = chaGordura;
        this.unidadeDeMedida = unidadeDeMedida;
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

    public Ingredientes getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingredientes ingredientes) {
        this.ingredientes = ingredientes;
    }

    public ChaGordura getChaGordura() {
        return chaGordura;
    }

    public void setChaGordura(ChaGordura chaGordura) {
        this.chaGordura = chaGordura;
    }

    public UnidadeDeMedida getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(UnidadeDeMedida unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }
}
