package br.com.iouone.repository;

import br.com.iouone.dto.PlanoDiarioDTO;
import br.com.iouone.entity.CardapioDetalhado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardapioDetalhadoRepository extends JpaRepository<CardapioDetalhado, Integer> {

    @Query("SELECT new br.com.iouone.dto.PlanoDiarioDTO(ca.nome,ca.descricao,ad.alimentacaoDiaria,cd.cardapios) " +
            "FROM CardapioDetalhado cd " +
            "LEFT JOIN cd.alimentacoesDiarias ad " +
            "LEFT JOIN cd.cardapioAtualizados ca " +
            "WHERE ca.id =:idCardapioAtualizado")
    List<PlanoDiarioDTO> buscarCardapioDetalhado(Integer idCardapioAtualizado);
}