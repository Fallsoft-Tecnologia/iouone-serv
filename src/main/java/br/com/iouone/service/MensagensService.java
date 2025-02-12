package br.com.iouone.service;

import br.com.iouone.dto.ComentarioDTO;
import br.com.iouone.dto.Comentariov2DTO;
import br.com.iouone.dto.MensagemDTO;
import org.springframework.data.domain.PageRequest;
import br.com.iouone.entity.ComentarioMensagem;
import br.com.iouone.entity.Mensagens;
import br.com.iouone.repository.ComentarioMensagemRepository;
import br.com.iouone.repository.MensagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MensagensService {

    @Autowired
    private MensagensRepository mensagensRepository;

    @Autowired
    private ComentarioMensagemRepository comentarioMensagemRepository;

    public List<ComentarioDTO> obterComentariosIniciaisPorMensagem(int id, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Mensagens mensagem = mensagensRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mensagem não encontrada"));

        Page<ComentarioMensagem> comentariosPage = comentarioMensagemRepository.findByFkMensagemInicialAndComentarioPaiIsNull(mensagem, pageable);

        return converterParaDTOs(comentariosPage.getContent());
    }


    public Mensagens createMensagem(Mensagens novaMensagem) {
        if (novaMensagem.getDataEnvio() == null) {
            novaMensagem.setDataEnvio(LocalDateTime.now());
        }
        return mensagensRepository.save(novaMensagem);
    }

    public Page<MensagemDTO> getAllMensagens(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.desc("dataEnvio")));
        Page<Mensagens> mensagensPage = mensagensRepository.findAll(pageable);

        return mensagensPage.map(mensagem ->
             new MensagemDTO(
                    mensagem.getId(),
                    mensagem.getMensagem(),
                    mensagem.getDataEnvio(),
                    mensagem.getPessoa().getNome(),
                    mensagem.getComentarios()
            )
        );

    }


    private ComentarioDTO converterParaDTO(ComentarioMensagem comentarioMensagem) {
        ComentarioDTO dto = new ComentarioDTO();
        dto.setId(comentarioMensagem.getId());
        dto.setMensagemComentario(comentarioMensagem.getMensagemComentario());
        dto.setFkMensagemInicial(comentarioMensagem.getFkMensagemInicial().getId());

        if (comentarioMensagem.getComentarioPai() != null) {
            dto.setFkComentarioPai(comentarioMensagem.getComentarioPai().getId());
        } else {
            dto.setFkComentarioPai(null);
        }

        if (comentarioMensagem.getPessoa() != null) {
            dto.setNomeCliente(comentarioMensagem.getPessoa().getNome());
        } else {
            dto.setNomeCliente("Desconhecido");
        }

        dto.setDataEnvio(comentarioMensagem.getDataEnvio());

        return dto;
    }


    private List<ComentarioDTO> converterParaDTOs(List<ComentarioMensagem> comentarios) {
        return comentarios.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }


    public List<ComentarioDTO> obterSubcomentarios(int comentarioPaiId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("dataEnvio").descending());
        ComentarioMensagem comentarioPai = comentarioMensagemRepository.findById(comentarioPaiId)
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado"));

        Page<ComentarioMensagem> subcomentarios = comentarioMensagemRepository.findByComentarioPai(comentarioPai, pageable);
        return subcomentarios.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }
}
