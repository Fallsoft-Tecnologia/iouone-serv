package br.com.iouone.repository;

import br.com.iouone.entity.ReceitasChaDesinchar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitasChaDesincharRepository extends JpaRepository<ReceitasChaDesinchar, Integer> {
}