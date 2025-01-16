package br.com.iouone.repository;

import br.com.iouone.entity.ComentarioMensagem;
import br.com.iouone.entity.Mensagens;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

@Repository
public interface ComentarioMensagemRepository extends JpaRepository<ComentarioMensagem, Integer> {
    Page<ComentarioMensagem> findByComentarioPai(ComentarioMensagem comentarioPai, Pageable pageable);

    Page<ComentarioMensagem> findByFkMensagemInicialAndComentarioPaiIsNull(Mensagens fkMensagemInicial, Pageable pageable);
}
