package br.com.iouone.repository;

import br.com.iouone.entity.Ingredientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientesRepository extends JpaRepository<Ingredientes, Integer> {
}