package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "unidade_de_medida")
public class UnidadeDeMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "unidade_de_medida")
    private String unidadeDeMedida;

    public UnidadeDeMedida() {
    }

    public UnidadeDeMedida(Integer id, String unidadeDeMedida) {
        this.id = id;
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(String unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }
}
