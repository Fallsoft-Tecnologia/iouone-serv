package br.com.iouone.repository;

import br.com.iouone.entity.ComentarioMensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentatioMensagemRepository extends JpaRepository<ComentarioMensagem, Integer> {
}
