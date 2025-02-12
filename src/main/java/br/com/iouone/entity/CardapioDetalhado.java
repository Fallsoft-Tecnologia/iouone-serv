package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cardapio_detalhado")
public class CardapioDetalhado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_cardapio_atualizados")
    private CardapioAtualizados cardapioAtualizados;

    @ManyToOne
    @JoinColumn(name = "id_alimentacoes_diarias")
    private AlimentacoesDiarias alimentacoesDiarias;

    private String cardapios;

    private String modoDePreparo;

    private String descricaoAlimentacaoDiaria;


    public CardapioDetalhado() {
    }

    public CardapioDetalhado(Integer id, CardapioAtualizados cardapioAtualizados, AlimentacoesDiarias alimentacoesDiarias,
                             String cardapios, String modoDePreparo, String descricaoAlimentacaoDiaria) {
        this.id = id;
        this.cardapioAtualizados = cardapioAtualizados;
        this.alimentacoesDiarias = alimentacoesDiarias;
        this.cardapios = cardapios;
        this.modoDePreparo = modoDePreparo;
        this.descricaoAlimentacaoDiaria = descricaoAlimentacaoDiaria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CardapioAtualizados getCardapioAtualizados() {
        return cardapioAtualizados;
    }

    public void setCardapioAtualizados(CardapioAtualizados cardapioAtualizados) {
        this.cardapioAtualizados = cardapioAtualizados;
    }

    public AlimentacoesDiarias getAlimentacoesDiarias() {
        return alimentacoesDiarias;
    }

    public void setAlimentacoesDiarias(AlimentacoesDiarias alimentacoesDiarias) {
        this.alimentacoesDiarias = alimentacoesDiarias;
    }

    public String getCardapios() {
        return cardapios;
    }

    public void setCardapios(String cardapios) {
        this.cardapios = cardapios;
    }

    public String getModoDePreparo() {
        return modoDePreparo;
    }

    public void setModoDePreparo(String modoDePreparo) {
        this.modoDePreparo = modoDePreparo;
    }

    public String getDescricaoAlimentacaoDiaria() {
        return descricaoAlimentacaoDiaria;
    }

    public void setDescricaoAlimentacaoDiaria(String descricaoAlimentacaoDiaria) {
        this.descricaoAlimentacaoDiaria = descricaoAlimentacaoDiaria;
    }
}

