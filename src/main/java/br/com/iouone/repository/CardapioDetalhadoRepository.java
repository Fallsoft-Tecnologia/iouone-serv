package br.com.iouone.repository;

import br.com.iouone.entity.CardapioDetalhado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardapioDetalhadoRepository extends JpaRepository<CardapioDetalhado, Integer> {
}