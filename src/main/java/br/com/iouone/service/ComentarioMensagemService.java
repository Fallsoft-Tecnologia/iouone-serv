package br.com.iouone.service;

import br.com.iouone.dto.Comentariov2DTO;
import br.com.iouone.entity.ComentarioMensagem;
import br.com.iouone.entity.Mensagens;
import br.com.iouone.entity.Pessoa;
import br.com.iouone.repository.ComentarioMensagemRepository;
import br.com.iouone.repository.MensagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ComentarioMensagemService {

    private final MensagensRepository mensagemRepository;

    private final ComentarioMensagemRepository comentarioMensagemRepository;

    private final PessoaService pessoaService;

    @Autowired
    public ComentarioMensagemService(MensagensRepository mensagemRepository, ComentarioMensagemRepository comentarioMensagemRepository, PessoaService pessoaService) {
        this.mensagemRepository = mensagemRepository;
        this.comentarioMensagemRepository = comentarioMensagemRepository;
        this.pessoaService = pessoaService;
    }

    public Comentariov2DTO adicionarComentario(int idMensagem, String mensagemComentario, Integer idComentarioPai, Integer idUsuario) {
        Optional<Mensagens> mensagemOpt = mensagemRepository.findById(idMensagem);
        if (mensagemOpt.isPresent()) {
            Mensagens mensagem = mensagemOpt.get();

            ComentarioMensagem novoComentario = new ComentarioMensagem();
            novoComentario.setFkMensagemInicial(mensagem);
            novoComentario.setMensagemComentario(mensagemComentario);

            novoComentario.setDataEnvio(LocalDateTime.now());

            Pessoa pessoa = pessoaService.findByIdPessoa(idUsuario);
            novoComentario.setPessoa(pessoa);

            if (idComentarioPai != null) {
                Optional<ComentarioMensagem> comentarioPaiOpt = comentarioMensagemRepository.findById(idComentarioPai);
                if (comentarioPaiOpt.isPresent()) {
                    ComentarioMensagem comentarioPai = comentarioPaiOpt.get();
                    novoComentario.setComentarioPai(comentarioPai);
                } else {
                    System.out.println("Comentário Pai não encontrado");
                }
            }

            var comentario = comentarioMensagemRepository.save(novoComentario);
            return new Comentariov2DTO(comentario.getId(),mensagemComentario,pessoa.getNome());
        } else {
            return new Comentariov2DTO();
        }
    }


}

