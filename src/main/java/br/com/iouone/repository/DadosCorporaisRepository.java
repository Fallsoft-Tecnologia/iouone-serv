package br.com.iouone.repository;

import br.com.iouone.entity.DadosCorporais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosCorporaisRepository extends JpaRepository<DadosCorporais, Integer> {
}
