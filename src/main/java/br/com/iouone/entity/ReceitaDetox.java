package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "receita_detox")
public class ReceitaDetox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_detox")
    private Detox detox;

    private String modoDePreparo;
    private String ingredientes;

    public ReceitaDetox() {
    }

    public ReceitaDetox(Integer id, Detox detox, String modoDePreparo, String ingredientes) {
        this.id = id;
        this.detox = detox;
        this.modoDePreparo = modoDePreparo;
        this.ingredientes = ingredientes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Detox getDetox() {
        return detox;
    }

    public void setDetox(Detox detox) {
        this.detox = detox;
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
