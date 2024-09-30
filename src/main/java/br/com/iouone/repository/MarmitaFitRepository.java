package br.com.iouone.repository;

import br.com.iouone.entity.MarmitaFit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarmitaFitRepository extends JpaRepository<MarmitaFit, Integer> {
}