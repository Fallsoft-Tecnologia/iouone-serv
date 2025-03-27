package br.com.iouone.repository;

import br.com.iouone.dto.PlanoDiarioDTO;
import br.com.iouone.dto.TreinoCompletoDTO;
import br.com.iouone.entity.TreinoCompleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreinoCompletoRepository extends JpaRepository<TreinoCompleto, Integer> {

    @Query("SELECT new br.com.iouone.dto.TreinoCompletoDTO(ta.nome,ta.descricao,tt.tipoTreino,tc.treinos) " +
            "FROM TreinoCompleto tc " +
            "LEFT JOIN tc.treinoAtualizado ta " +
            "LEFT JOIN tc.tipoTreino tt " +
            "WHERE ta.id =:idTreinoCompleto")
    List<TreinoCompletoDTO> buscarDadosTreinoCompleto(Integer idTreinoCompleto);
}