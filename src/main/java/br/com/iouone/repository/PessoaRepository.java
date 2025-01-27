package br.com.iouone.repository;

import br.com.iouone.dto.DadosEnderecoPessoaDTO;
import br.com.iouone.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    Optional<Pessoa> findByEmail(String email);
    Optional<Pessoa> findById(Long id);

    Pessoa findByFluxoId(String fluxoId);

    Optional<Pessoa> findByCpf(String cpf);

    @Query("SELECT new br.com.iouone.dto.DadosEnderecoPessoaDTO(e.endereco,e.estado,e.paises,e.cidade,e.cep,p.customerId) " +
            "FROM Pessoa p " +
            "LEFT JOIN p.endereco e " +
            "WHERE p.fluxoId = :fluxoId")
    DadosEnderecoPessoaDTO buscarEnderecoPessoaPorFluxoId(String fluxoId);

}
