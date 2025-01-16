package br.com.iouone.repository;

import br.com.iouone.entity.TipoTreino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTreinoRepository extends JpaRepository<TipoTreino, Integer> {
}