package br.com.iouone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_comentario_mensagem")
public class ComentarioMensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_mensagem_inicial")
    private Mensagens mensagemInicial;
    @ManyToOne
    @JoinColumn(name = "fk_mensagem_comentario")
    private Mensagens mensagemComentario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Mensagens getMensagemInicial() {
        return mensagemInicial;
    }

    public void setMensagemInicial(Mensagens mensagemInicial) {
        this.mensagemInicial = mensagemInicial;
    }

    public Mensagens getMensagemComentario() {
        return mensagemComentario;
    }

    public void setMensagemComentario(Mensagens mensagemComentario) {
        this.mensagemComentario = mensagemComentario;
    }
}
