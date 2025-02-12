package br.com.iouone.repository;

import br.com.iouone.dto.ReceitasDTO;
import br.com.iouone.entity.ReceitaDetox;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaDetoxRepository extends JpaRepository<ReceitaDetox, Integer> {

    @Query("SELECT new br.com.iouone.dto.ReceitasDTO(d.nome,d.descricao,rd.ingredientes,rd.modoDePreparo) " +
            "FROM ReceitaDetox rd " +
            "LEFT JOIN rd.detox d " +
            "WHERE d.id =:idDetox ")
    ReceitasDTO buscarReceitasMarmitaFit(@Param("idDetox") Integer idDetox);
}