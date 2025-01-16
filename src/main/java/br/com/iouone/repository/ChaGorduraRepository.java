package br.com.iouone.repository;

import br.com.iouone.entity.ChaGordura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChaGorduraRepository extends JpaRepository<ChaGordura, Integer> {
}