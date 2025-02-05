package br.com.iouone.repository;

import br.com.iouone.dto.DadosCorporaisDTO;
import br.com.iouone.entity.DadosCorporais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosCorporaisRepository extends JpaRepository<DadosCorporais, Integer> {

    @Query("SELECT new br.com.iouone.dto.DadosCorporaisDTO(dc.id,dc.altura,dc.pesoAtual,dc.pesoIdeal) " +
            "FROM Pessoa p " +
            "LEFT JOIN p.dadosCorporais dc " +
            "WHERE p.id =:idPessoa")
    DadosCorporaisDTO buscarDadosCorporais(Integer idPessoa);
}
