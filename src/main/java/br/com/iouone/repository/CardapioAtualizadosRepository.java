package br.com.iouone.repository;

import br.com.iouone.entity.CardapioAtualizados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardapioAtualizadosRepository extends JpaRepository<CardapioAtualizados, Integer> {
}