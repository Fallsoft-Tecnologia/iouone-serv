package br.com.iouone.repository;

import br.com.iouone.entity.Mensagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagensRepository extends JpaRepository<Mensagens,Integer> {
}
