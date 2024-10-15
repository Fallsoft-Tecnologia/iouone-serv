package br.com.iouone.service;

import br.com.iouone.entity.ComentarioMensagem;
import br.com.iouone.entity.Mensagens;
import br.com.iouone.entity.Pessoa;
import br.com.iouone.repository.ComentarioMensagemRepository;
import br.com.iouone.repository.MensagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ComentarioMensagemService {

    @Autowired
    private MensagensRepository mensagemRepository;

    @Autowired
    private ComentarioMensagemRepository comentarioMensagemRepository;

    public void adicionarComentario(int idMensagem, String mensagemComentario, Integer idComentarioPai) {
        Optional<Mensagens> mensagemOpt = mensagemRepository.findById(idMensagem);
        if (mensagemOpt.isPresent()) {
            Mensagens mensagem = mensagemOpt.get();

            ComentarioMensagem novoComentario = new ComentarioMensagem();
            novoComentario.setFkMensagemInicial(mensagem);
            novoComentario.setMensagemComentario(mensagemComentario);

            novoComentario.setDataEnvio(LocalDate.now());

            Pessoa pessoa = mensagem.getPessoa();
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

            comentarioMensagemRepository.save(novoComentario);
        } else {
            System.out.println("Mensagem não encontrada");
        }
    }


}

