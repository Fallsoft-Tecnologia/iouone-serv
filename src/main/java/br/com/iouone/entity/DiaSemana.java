package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dia_semana")
public class DiaSemana {

    @Id
    private Integer id;

    @Column(name = "dia_semana")
    private String diaSemana;

    public DiaSemana() {
    }

    public DiaSemana(Integer id, String diaSemana) {
        this.id = id;
        this.diaSemana = diaSemana;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }
}
