package br.com.iouone.repository;

import br.com.iouone.entity.FitDance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitDanceRepository extends JpaRepository<FitDance, Integer> {
}