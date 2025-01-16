package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cardapio_detalhado")
public class CardapioDetalhado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float quantidade;

    @Column(name = "id_cardapio_atualizados")
    private Integer idCardapioAtualizados;

    @Column(name = "id_alimentacoes_diarias")
    private Integer idAlimentacoesDiarias;

    @Column(name = "id_dia_semana")
    private Integer idDiaSemana;

    @Column(name = "id_unidade_de_medida")
    private Integer idUnidadeDeMedida;

    @Column(name = "id_ingredientes")
    private Integer idIngredientes;

    public CardapioDetalhado() {
    }

    public CardapioDetalhado(Integer id, Float quantidade, Integer idCardapioAtualizados, Integer idAlimentacoesDiarias, Integer idDiaSemana, Integer idUnidadeDeMedida, Integer idIngredientes) {
        this.id = id;
        this.quantidade = quantidade;
        this.idCardapioAtualizados = idCardapioAtualizados;
        this.idAlimentacoesDiarias = idAlimentacoesDiarias;
        this.idDiaSemana = idDiaSemana;
        this.idUnidadeDeMedida = idUnidadeDeMedida;
        this.idIngredientes = idIngredientes;
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

    public Integer getIdCardapioAtualizados() {
        return idCardapioAtualizados;
    }

    public void setIdCardapioAtualizados(Integer idCardapioAtualizados) {
        this.idCardapioAtualizados = idCardapioAtualizados;
    }

    public Integer getIdAlimentacoesDiarias() {
        return idAlimentacoesDiarias;
    }

    public void setIdAlimentacoesDiarias(Integer idAlimentacoesDiarias) {
        this.idAlimentacoesDiarias = idAlimentacoesDiarias;
    }

    public Integer getIdDiaSemana() {
        return idDiaSemana;
    }

    public void setIdDiaSemana(Integer idDiaSemana) {
        this.idDiaSemana = idDiaSemana;
    }

    public Integer getIdUnidadeDeMedida() {
        return idUnidadeDeMedida;
    }

    public void setIdUnidadeDeMedida(Integer idUnidadeDeMedida) {
        this.idUnidadeDeMedida = idUnidadeDeMedida;
    }

    public Integer getIdIngredientes() {
        return idIngredientes;
    }

    public void setIdIngredientes(Integer idIngredientes) {
        this.idIngredientes = idIngredientes;
    }
}

