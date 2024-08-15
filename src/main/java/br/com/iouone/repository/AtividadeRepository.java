package br.com.iouone.repository;

import br.com.iouone.entity.AtividadeFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeRepository extends JpaRepository<AtividadeFisica,Integer> {
}
