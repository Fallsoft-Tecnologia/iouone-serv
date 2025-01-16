package br.com.iouone.repository;

import br.com.iouone.entity.AlimentacoesDiarias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentacoesDiariasRepository extends JpaRepository<AlimentacoesDiarias, Integer> {
}