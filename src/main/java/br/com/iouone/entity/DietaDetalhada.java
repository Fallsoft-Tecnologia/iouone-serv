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
    @JoinColumn(name = "id_dietas_atualizadas")
    private DietasAtualizadas dietasAtualizadas;

    @Column(name = "dietas")
    private String dietas;



    public DietaDetalhada() {
    }

    public DietaDetalhada(Integer id, AlimentacoesDiarias alimentacoesDiarias, DietasAtualizadas dietasAtualizadas, String dietas) {
        this.id = id;
        this.alimentacoesDiarias = alimentacoesDiarias;
        this.dietasAtualizadas = dietasAtualizadas;
        this.dietas = dietas;
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

    public DietasAtualizadas getDietasAtualizadas() {
        return dietasAtualizadas;
    }

    public void setDietasAtualizadas(DietasAtualizadas dietasAtualizadas) {
        this.dietasAtualizadas = dietasAtualizadas;
    }

    public String getDietas() {
        return dietas;
    }

    public void setDietas(String dietas) {
        this.dietas = dietas;
    }
}
