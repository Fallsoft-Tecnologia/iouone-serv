package br.com.iouone.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_atividade_fisica")
public class AtividadeFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "atividade_fisica")
    private String atividadeFisica;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAtividadeFisica() {
        return atividadeFisica;
    }

    public void setAtividadeFisica(String atividadeFisica) {
        this.atividadeFisica = atividadeFisica;
    }
}
