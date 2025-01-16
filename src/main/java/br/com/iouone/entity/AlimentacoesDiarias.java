package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "alimentacoes_diarias")
public class AlimentacoesDiarias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "alimentacao_diaria")
    private String alimentacaoDiaria;

    public AlimentacoesDiarias() {
    }

    public AlimentacoesDiarias(Integer id, String alimentacaoDiaria) {
        this.id = id;
        this.alimentacaoDiaria = alimentacaoDiaria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlimentacaoDiaria() {
        return alimentacaoDiaria;
    }

    public void setAlimentacaoDiaria(String alimentacaoDiaria) {
        this.alimentacaoDiaria = alimentacaoDiaria;
    }
}
