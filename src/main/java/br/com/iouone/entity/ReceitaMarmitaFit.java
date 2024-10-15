package br.com.iouone.entity;

import jakarta.persistence.*;
import java.util.Objects;

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

    // Relacionamentos
    @ManyToOne
    @JoinColumn(name = "id_marmita_fit", insertable = false, updatable = false)
    private MarmitaFit marmitaFit;

    @ManyToOne
    @JoinColumn(name = "id_ingredientes", insertable = false, updatable = false)
    private Ingredientes ingredientes;

    @ManyToOne
    @JoinColumn(name = "id_unidade_de_medida", insertable = false, updatable = false)
    private UnidadeDeMedida unidadeDeMedida;

    public ReceitaMarmitaFit() {
    }

    public ReceitaMarmitaFit(Integer id, Integer quantidade, Integer idMarmitaFit, Integer idIngredientes, Integer idUnidadeDeMedida) {
        this.id = id;
        this.quantidade = quantidade;
        this.idMarmitaFit = idMarmitaFit;
        this.idIngredientes = idIngredientes;
        this.idUnidadeDeMedida = idUnidadeDeMedida;
    }

    // Getters e Setters

    @Override
    public String toString() {
        return "ReceitaMarmitaFit{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", idMarmitaFit=" + idMarmitaFit +
                ", idIngredientes=" + idIngredientes +
                ", idUnidadeDeMedida=" + idUnidadeDeMedida +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReceitaMarmitaFit)) return false;
        ReceitaMarmitaFit that = (ReceitaMarmitaFit) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public MarmitaFit getMarmitaFit() {
        return marmitaFit;
    }

    public void setMarmitaFit(MarmitaFit marmitaFit) {
        this.marmitaFit = marmitaFit;
    }

    public Ingredientes getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingredientes ingredientes) {
        this.ingredientes = ingredientes;
    }

    public UnidadeDeMedida getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(UnidadeDeMedida unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }
}
