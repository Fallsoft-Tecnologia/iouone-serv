package br.com.iouone.repository;

import br.com.iouone.entity.UnidadeDeMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeDeMedidaRepository extends JpaRepository<UnidadeDeMedida, Integer> {
}