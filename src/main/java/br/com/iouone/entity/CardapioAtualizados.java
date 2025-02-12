package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cardapio_atualizados")
public class CardapioAtualizados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private byte[] foto;

    public CardapioAtualizados() {
    }

    public CardapioAtualizados(Integer id, String nome, String descricao, byte[] foto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.foto = foto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
