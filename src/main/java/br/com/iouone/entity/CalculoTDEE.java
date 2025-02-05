package br.com.iouone.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_calculo_tdee")
public class CalculoTDEE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "fk_pessoa")
    private Pessoa pessoa;

    @Column(name = "tdee")
    private Double tdee;

    @Column(name = "calorias_diarias")
    private Double caloriasDiarias;

    @Column(name = "data_calculo")
    private LocalDate dataCalculo;

    @ManyToOne
    @JoinColumn(name = "fk_objetivo")
    private Objetivo objetivo;

    @ManyToOne
    @JoinColumn(name = "fk_biotipo")
    private Biotipo biotipo;

    public CalculoTDEE() {
    }

    public CalculoTDEE(int id, Pessoa pessoa, Double tdee, Double caloriasDiarias, LocalDate dataCalculo, Objetivo objetivo, Biotipo biotipo) {
        this.id = id;
        this.pessoa = pessoa;
        this.tdee = tdee;
        this.caloriasDiarias = caloriasDiarias;
        this.dataCalculo = dataCalculo;
        this.objetivo = objetivo;
        this.biotipo = biotipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getTdee() {
        return tdee;
    }

    public void setTdee(Double tdee) {
        this.tdee = tdee;
    }

    public Double getCaloriasDiarias() {
        return caloriasDiarias;
    }

    public void setCaloriasDiarias(Double caloriasDiarias) {
        this.caloriasDiarias = caloriasDiarias;
    }

    public LocalDate getDataCalculo() {
        return dataCalculo;
    }

    public void setDataCalculo(LocalDate dataCalculo) {
        this.dataCalculo = dataCalculo;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public Biotipo getBiotipo() {
        return biotipo;
    }

    public void setBiotipo(Biotipo biotipo) {
        this.biotipo = biotipo;
    }
}
