package br.com.iouone.repository;

import br.com.iouone.entity.ReceitaChaGordura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaChaGorduraRepository extends JpaRepository<ReceitaChaGordura, Integer> {
}