package br.com.iouone.repository;

import br.com.iouone.entity.ReceitaMarmitaFit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaMarmitaFitRepository extends JpaRepository<ReceitaMarmitaFit, Integer> {
}