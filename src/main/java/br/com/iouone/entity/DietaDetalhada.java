package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dieta_detalhada")
public class DietaDetalhada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_alimentacoes_diarias")
    private AlimentacoesDiarias alimentacoesDiarias;

    @ManyToOne
    @JoinColumn(name = "id_dia_semana")
    private DiaSemana diaSemana;

    @ManyToOne
    @JoinColumn(name = "id_dietas_atualizadas")
    private DietasAtualizadas dietasAtualizadas;

    @ManyToOne
    @JoinColumn(name = "id_ingredientes")
    private Ingredientes ingredientes;

    @ManyToOne
    @JoinColumn(name = "id_unidade_de_medida")
    private UnidadeDeMedida unidadeDeMedida;

    private Float quantidade;

    public DietaDetalhada() {
    }

    public DietaDetalhada(Integer id, AlimentacoesDiarias alimentacoesDiarias, DiaSemana diaSemana, DietasAtualizadas dietasAtualizadas, Ingredientes ingredientes, UnidadeDeMedida unidadeDeMedida, Float quantidade) {
        this.id = id;
        this.alimentacoesDiarias = alimentacoesDiarias;
        this.diaSemana = diaSemana;
        this.dietasAtualizadas = dietasAtualizadas;
        this.ingredientes = ingredientes;
        this.unidadeDeMedida = unidadeDeMedida;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AlimentacoesDiarias getAlimentacoesDiarias() {
        return alimentacoesDiarias;
    }

    public void setAlimentacoesDiarias(AlimentacoesDiarias alimentacoesDiarias) {
        this.alimentacoesDiarias = alimentacoesDiarias;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public DietasAtualizadas getDietasAtualizadas() {
        return dietasAtualizadas;
    }

    public void setDietasAtualizadas(DietasAtualizadas dietasAtualizadas) {
        this.dietasAtualizadas = dietasAtualizadas;
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

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }
}
