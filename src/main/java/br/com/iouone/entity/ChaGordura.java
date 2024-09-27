package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cha_gordura")
public class ChaGordura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private String modoDePreparo;

    @Lob
    private byte[] foto;

    public ChaGordura() {
    }

    public ChaGordura(Integer id, String nome, String descricao, String modoDePreparo, byte[] foto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.modoDePreparo = modoDePreparo;
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

    public String getModoDePreparo() {
        return modoDePreparo;
    }

    public void setModoDePreparo(String modoDePreparo) {
        this.modoDePreparo = modoDePreparo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
