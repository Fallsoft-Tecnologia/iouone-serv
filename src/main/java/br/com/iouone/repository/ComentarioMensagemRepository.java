package br.com.iouone.repository;

import br.com.iouone.dto.Comentariov2DTO;
import br.com.iouone.entity.ComentarioMensagem;
import br.com.iouone.entity.Mensagens;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface ComentarioMensagemRepository extends JpaRepository<ComentarioMensagem, Integer> {
    Page<ComentarioMensagem> findByComentarioPai(ComentarioMensagem comentarioPai, Pageable pageable);

    Page<ComentarioMensagem> findByFkMensagemInicialAndComentarioPaiIsNull(Mensagens fkMensagemInicial, Pageable pageable);

    @Query("SELECT new br.com.iouone.dto.Comentariov2DTO(cm.id,fmi.mensagem,fmi.pessoa.nome)" +
            "FROM ComentarioMensagem cm " +
            "LEFT JOIN cm.fkMensagemInicial fmi " +
            "WHERE cm.fkMensagemInicial.id =:idMensagemInicial " +
            "ORDER BY cm.dataEnvio DESC")
    Page<Comentariov2DTO> buscarComentario(Integer idMensagemInicial,Pageable pageable);
}
