package br.com.iouone.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "receita_marmita_fit")
public class ReceitaMarmitaFit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_marmita_fit", insertable = false, updatable = false)
    private MarmitaFit marmitaFit;

    private String modoDePreparo;
    private String ingredientes;

    public ReceitaMarmitaFit() {
    }

    public ReceitaMarmitaFit(Integer id, MarmitaFit marmitaFit, String modoDePreparo, String ingredientes) {
        this.id = id;
        this.marmitaFit = marmitaFit;
        this.modoDePreparo = modoDePreparo;
        this.ingredientes = ingredientes;
    }

    // Getters e Setters



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReceitaMarmitaFit)) return false;
        ReceitaMarmitaFit that = (ReceitaMarmitaFit) o;
        return Objects.equals(id, that.id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MarmitaFit getMarmitaFit() {
        return marmitaFit;
    }

    public void setMarmitaFit(MarmitaFit marmitaFit) {
        this.marmitaFit = marmitaFit;
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
