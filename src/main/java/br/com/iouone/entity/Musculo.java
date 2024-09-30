package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "musculo")
public class Musculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String musculo;

    public Musculo() {
    }

    public Musculo(Integer id, String musculo) {
        this.id = id;
        this.musculo = musculo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMusculo() {
        return musculo;
    }

    public void setMusculo(String musculo) {
        this.musculo = musculo;
    }
}
