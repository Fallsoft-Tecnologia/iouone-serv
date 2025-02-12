package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "receitas_cha_desinchar")
public class ReceitasChaDesinchar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_cha_desinchar")
    private ChaDesinchar chaDesinchar;

    private String modoDePreparo;
    private String ingredientes;

    public ReceitasChaDesinchar() {
    }

    public ReceitasChaDesinchar(Integer id, ChaDesinchar chaDesinchar, String modoDePreparo, String ingredientes) {
        this.id = id;
        this.chaDesinchar = chaDesinchar;
        this.modoDePreparo = modoDePreparo;
        this.ingredientes = ingredientes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ChaDesinchar getChaDesinchar() {
        return chaDesinchar;
    }

    public void setChaDesinchar(ChaDesinchar chaDesinchar) {
        this.chaDesinchar = chaDesinchar;
    }

    public String getModoDePreparo() {
        return modoDePreparo;
    }

    public void setModoDePreparo(String modoDePreparo) {
        this.modoDePreparo = modoDePreparo;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
}
