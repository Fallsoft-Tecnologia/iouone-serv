package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_paises")
public class Paises {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "pais")
    private String pais;
    @Column(name = "abreviacao")
    private String abreviacao;

    public Paises() {
    }

    public Paises(Integer id, String pais, String abreviacao) {
        this.id = id;
        this.pais = pais;
        this.abreviacao = abreviacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }
}
