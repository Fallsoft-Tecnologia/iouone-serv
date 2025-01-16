package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "receitas_cha_desinchar")
public class ReceitasChaDesinchar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float quantidade;

    @Column(name = "id_ingredientes")
    private Integer idIngredientes;

    @Column(name = "id_cha_desinchar")
    private Integer idChaDesinchar;

    @Column(name = "id_unidade_de_medida")
    private Integer idUnidadeDeMedida;

    public ReceitasChaDesinchar() {
    }

    public ReceitasChaDesinchar(Integer id, Float quantidade, Integer idIngredientes, Integer idChaDesinchar, Integer idUnidadeDeMedida) {
        this.id = id;
        this.quantidade = quantidade;
        this.idIngredientes = idIngredientes;
        this.idChaDesinchar = idChaDesinchar;
        this.idUnidadeDeMedida = idUnidadeDeMedida;
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

    public Integer getIdIngredientes() {
        return idIngredientes;
    }

    public void setIdIngredientes(Integer idIngredientes) {
        this.idIngredientes = idIngredientes;
    }

    public Integer getIdChaDesinchar() {
        return idChaDesinchar;
    }

    public void setIdChaDesinchar(Integer idChaDesinchar) {
        this.idChaDesinchar = idChaDesinchar;
    }

    public Integer getIdUnidadeDeMedida() {
        return idUnidadeDeMedida;
    }

    public void setIdUnidadeDeMedida(Integer idUnidadeDeMedida) {
        this.idUnidadeDeMedida = idUnidadeDeMedida;
    }
}
