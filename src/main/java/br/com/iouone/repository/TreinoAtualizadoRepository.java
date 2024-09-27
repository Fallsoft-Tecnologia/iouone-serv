package br.com.iouone.repository;

import br.com.iouone.entity.TreinoAtualizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinoAtualizadoRepository extends JpaRepository<TreinoAtualizado, Integer> {
}