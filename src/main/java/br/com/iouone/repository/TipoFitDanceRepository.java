package br.com.iouone.repository;

import br.com.iouone.entity.TipoFitDance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoFitDanceRepository extends JpaRepository<TipoFitDance, Integer> {
}