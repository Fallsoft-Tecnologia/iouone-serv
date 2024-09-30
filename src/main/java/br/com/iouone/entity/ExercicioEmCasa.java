package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "exercicio_em_casa")
public class ExercicioEmCasa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(name = "url_treino_casa")
    private String urlTreinoCasa;

    @Lob
    private byte[] video;

    @Lob
    private byte[] foto;

    public ExercicioEmCasa() {
    }

    public ExercicioEmCasa(Integer id, String nome, String urlTreinoCasa, byte[] video, byte[] foto) {
        this.id = id;
        this.nome = nome;
        this.urlTreinoCasa = urlTreinoCasa;
        this.video = video;
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

    public String getUrlTreinoCasa() {
        return urlTreinoCasa;
    }

    public void setUrlTreinoCasa(String urlTreinoCasa) {
        this.urlTreinoCasa = urlTreinoCasa;
    }

    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
        this.video = video;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
