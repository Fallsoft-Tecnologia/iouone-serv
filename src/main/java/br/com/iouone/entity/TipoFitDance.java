package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_fit_dance")
public class TipoFitDance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo_fit_dance")
    private String tipoFitDance;

    public TipoFitDance() {
    }

    public TipoFitDance(Integer id, String tipoFitDance) {
        this.id = id;
        this.tipoFitDance = tipoFitDance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoFitDance() {
        return tipoFitDance;
    }

    public void setTipoFitDance(String tipoFitDance) {
        this.tipoFitDance = tipoFitDance;
    }
}
