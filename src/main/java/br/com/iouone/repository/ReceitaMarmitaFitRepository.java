package br.com.iouone.repository;

import br.com.iouone.dto.ReceitasDTO;
import br.com.iouone.entity.ReceitaMarmitaFit;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaMarmitaFitRepository extends JpaRepository<ReceitaMarmitaFit, Integer> {

    @Query("SELECT new br.com.iouone.dto.ReceitasDTO(mf.nome,mf.descricao,rmf.ingredientes,rmf.modoDePreparo) " +
            "FROM ReceitaMarmitaFit rmf " +
            "LEFT JOIN rmf.marmitaFit mf " +
            "WHERE mf.id =:idMarmitaFit ")
    ReceitasDTO buscarReceitasMarmitaFit(@Param("idMarmitaFit") Integer idMarmitaFit);
}