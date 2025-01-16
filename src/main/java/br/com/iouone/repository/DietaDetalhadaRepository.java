package br.com.iouone.repository;

import br.com.iouone.entity.DietaDetalhada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietaDetalhadaRepository extends JpaRepository<DietaDetalhada, Integer> {
}