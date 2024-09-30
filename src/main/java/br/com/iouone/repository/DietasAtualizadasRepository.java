package br.com.iouone.repository;

import br.com.iouone.entity.DietasAtualizadas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietasAtualizadasRepository extends JpaRepository<DietasAtualizadas, Integer> {
}