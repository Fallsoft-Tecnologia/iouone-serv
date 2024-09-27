package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fit_dance")
public class FitDance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(name = "url_fit_dance")
    private String urlFitDance;

    @Lob
    private byte[] video;

    private Integer contadorVistos;

    @ManyToOne
    @JoinColumn(name = "id_tipo_fit_dance")
    private TipoFitDance tipoFitDance;

    private String autor;

    @Lob
    private byte[] foto;

    public FitDance() {
    }

    public FitDance(Integer id, String nome, String urlFitDance, byte[] video, Integer contadorVistos, TipoFitDance tipoFitDance, String autor, byte[] foto) {
        this.id = id;
        this.nome = nome;
        this.urlFitDance = urlFitDance;
        this.video = video;
        this.contadorVistos = contadorVistos;
        this.tipoFitDance = tipoFitDance;
        this.autor = autor;
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

    public String getUrlFitDance() {
        return urlFitDance;
    }

    public void setUrlFitDance(String urlFitDance) {
        this.urlFitDance = urlFitDance;
    }

    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
        this.video = video;
    }

    public Integer getContadorVistos() {
        return contadorVistos;
    }

    public void setContadorVistos(Integer contadorVistos) {
        this.contadorVistos = contadorVistos;
    }

    public TipoFitDance getTipoFitDance() {
        return tipoFitDance;
    }

    public void setTipoFitDance(TipoFitDance tipoFitDance) {
        this.tipoFitDance = tipoFitDance;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
