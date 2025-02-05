package br.com.iouone.repository;

import br.com.iouone.dto.DadosPessoaTDEEDTO;
import br.com.iouone.entity.CalculoTDEE;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CalculoTDEERepository extends JpaRepository<CalculoTDEE, Integer> {

    @Query("SELECT ct.id FROM CalculoTDEE ct where ct.pessoa.id =:idPessoa")
    Integer buscarIdCalculoTDEE(Integer idPessoa);

}