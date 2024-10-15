package br.com.iouone.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_comentario_mensagem")
public class ComentarioMensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "fk_mensagem_inicial")
    @JsonBackReference(value = "mensagem-comentario") // Nome correspondente para a referência
    private Mensagens fkMensagemInicial;

    @ManyToOne
    @JoinColumn(name = "fk_comentario_pai")
    @JsonBackReference(value = "comentario-pai") // Nome para evitar conflito
    private ComentarioMensagem comentarioPai;

    @OneToMany(mappedBy = "comentarioPai", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "comentario-pai") // Nome correspondente
    private List<ComentarioMensagem> subcomentarios = new ArrayList<>();

    @Column(name = "mensagem_comentario")
    private String mensagemComentario;

    @Column(name = "data_envio")
    private LocalDate dataEnvio;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mensagens getFkMensagemInicial() {
        return fkMensagemInicial;
    }

    public void setFkMensagemInicial(Mensagens fkMensagemInicial) {
        this.fkMensagemInicial = fkMensagemInicial;
    }

    public ComentarioMensagem getComentarioPai() {
        return comentarioPai;
    }

    public void setComentarioPai(ComentarioMensagem comentarioPai) {
        this.comentarioPai = comentarioPai;
    }

    public List<ComentarioMensagem> getSubcomentarios() {
        return subcomentarios;
    }

    public void setSubcomentarios(List<ComentarioMensagem> subcomentarios) {
        this.subcomentarios = subcomentarios;
    }

    public String getMensagemComentario() {
        return mensagemComentario;
    }

    public void setMensagemComentario(String mensagemComentario) {
        this.mensagemComentario = mensagemComentario;
    }

    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    @Override
    public String toString() {
        return "ComentarioMensagem{" +
                "id=" + id +
                ", mensagemComentario='" + mensagemComentario + '\'' +
                '}';
    }
}