package br.com.iouone.repository;

import br.com.iouone.entity.ChaDesinchar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChaDesincharRepository extends JpaRepository<ChaDesinchar, Integer> {
}