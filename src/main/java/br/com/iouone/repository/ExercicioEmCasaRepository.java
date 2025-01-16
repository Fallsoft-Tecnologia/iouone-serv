package br.com.iouone.repository;

import br.com.iouone.entity.ExercicioEmCasa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioEmCasaRepository extends JpaRepository<ExercicioEmCasa, Integer> {
}