package br.com.iouone.repository;

import br.com.iouone.entity.TreinoCompleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinoCompletoRepository extends JpaRepository<TreinoCompleto, Integer> {
}