package br.com.iouone.repository;

import br.com.iouone.dto.ReceitasDTO;
import br.com.iouone.entity.ReceitasChaDesinchar;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitasChaDesincharRepository extends JpaRepository<ReceitasChaDesinchar, Integer> {

    @Query("SELECT new br.com.iouone.dto.ReceitasDTO(cd.nome,cd.descricao,rcd.ingredientes,rcd.modoDePreparo) " +
            "FROM ReceitasChaDesinchar rcd " +
            "LEFT JOIN rcd.chaDesinchar cd " +
            "WHERE cd.id =:idChaDesinchar ")
    ReceitasDTO buscarReceitasChaDesinchar(@Param("idChaDesinchar") Integer idChaDesinchar);
}