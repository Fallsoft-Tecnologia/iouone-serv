package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_treino")
public class TipoTreino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo_treino")
    private String tipoTreino;

    public TipoTreino() {
    }

    public TipoTreino(Integer id, String tipoTreino) {
        this.id = id;
        this.tipoTreino = tipoTreino;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoTreino() {
        return tipoTreino;
    }

    public void setTipoTreino(String tipoTreino) {
        this.tipoTreino = tipoTreino;
    }
}
