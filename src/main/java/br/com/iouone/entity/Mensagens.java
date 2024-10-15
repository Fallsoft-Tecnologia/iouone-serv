package br.com.iouone.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_mensagens")
public class Mensagens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "mensagem")
    private String mensagem;

    @Column(name = "data_envio")
    private LocalDate dataEnvio;

    @ManyToOne
    @JoinColumn(name = "fk_enviado_por")
    private Pessoa pessoa;

    @OneToMany(mappedBy = "fkMensagemInicial", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "mensagem-comentario") // Nome para a referência
    private List<ComentarioMensagem> comentarios;

    public Mensagens() {
        this.dataEnvio = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<ComentarioMensagem> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioMensagem> comentarios) {
        this.comentarios = comentarios;
    }
}
