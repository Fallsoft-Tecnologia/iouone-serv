package br.com.iouone.repository;

import br.com.iouone.dto.PlanoDiarioDTO;
import br.com.iouone.entity.DietaDetalhada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DietaDetalhadaRepository extends JpaRepository<DietaDetalhada, Integer> {

    @Query("SELECT new br.com.iouone.dto.PlanoDiarioDTO(da.nome,da.descricao,ad.alimentacaoDiaria,dd.dietas) " +
            "FROM DietaDetalhada dd " +
            "LEFT JOIN dd.alimentacoesDiarias ad " +
            "LEFT JOIN dd.dietasAtualizadas da " +
            "WHERE da.id =:idDietaDetalhada")
    List<PlanoDiarioDTO> buscarDadosDieta(Integer idDietaDetalhada);
}