package br.com.iouone.repository;

import br.com.iouone.entity.ReceitaDetox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaDetoxRepository extends JpaRepository<ReceitaDetox, Integer> {
}