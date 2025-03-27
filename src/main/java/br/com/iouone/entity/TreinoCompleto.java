package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "treino_completo")
public class TreinoCompleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_tipo_treino")
    private TipoTreino tipoTreino;

    @ManyToOne
    @JoinColumn(name = "id_treino_atualizado")
    private TreinoAtualizado treinoAtualizado;

    private String treinos;

    public TreinoCompleto() {
    }

    public TreinoCompleto(Integer id, TipoTreino tipoTreino, TreinoAtualizado treinoAtualizado, String treinos) {
        this.id = id;
        this.tipoTreino = tipoTreino;
        this.treinoAtualizado = treinoAtualizado;
        this.treinos = treinos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoTreino getTipoTreino() {
        return tipoTreino;
    }

    public void setTipoTreino(TipoTreino tipoTreino) {
        this.tipoTreino = tipoTreino;
    }


    public TreinoAtualizado getTreinoAtualizado() {
        return treinoAtualizado;
    }

    public void setTreinoAtualizado(TreinoAtualizado treinoAtualizado) {
        this.treinoAtualizado = treinoAtualizado;
    }

    public String getTreinos() {
        return treinos;
    }

    public void setTreinos(String treinos) {
        this.treinos = treinos;
    }
}
