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
    @JoinColumn(name = "id_exercicio")
    private Exercicio exercicio;

    @ManyToOne
    @JoinColumn(name = "id_musculo")
    private Musculo musculo;

    @ManyToOne
    @JoinColumn(name = "id_treino_atualizado")
    private TreinoAtualizado treinoAtualizado;

    public TreinoCompleto() {
    }

    public TreinoCompleto(Integer id, TipoTreino tipoTreino, Exercicio exercicio, Musculo musculo, TreinoAtualizado treinoAtualizado) {
        this.id = id;
        this.tipoTreino = tipoTreino;
        this.exercicio = exercicio;
        this.musculo = musculo;
        this.treinoAtualizado = treinoAtualizado;
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

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public Musculo getMusculo() {
        return musculo;
    }

    public void setMusculo(Musculo musculo) {
        this.musculo = musculo;
    }

    public TreinoAtualizado getTreinoAtualizado() {
        return treinoAtualizado;
    }

    public void setTreinoAtualizado(TreinoAtualizado treinoAtualizado) {
        this.treinoAtualizado = treinoAtualizado;
    }
}
