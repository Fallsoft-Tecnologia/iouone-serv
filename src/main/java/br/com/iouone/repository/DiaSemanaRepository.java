package br.com.iouone.repository;

import br.com.iouone.entity.DiaSemana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaSemanaRepository extends JpaRepository<DiaSemana, Integer> {
}