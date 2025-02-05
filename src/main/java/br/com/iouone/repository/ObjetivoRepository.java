package br.com.iouone.repository;

import br.com.iouone.entity.Objetivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjetivoRepository extends JpaRepository<Objetivo, Integer> {

    Objetivo findObjetivoByObjetivo(String objetivo);
}