package br.com.iouone.repository;

import br.com.iouone.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    Optional<Pessoa> findByEmail(String email);
    Optional<Pessoa> findById(Long id);

    Pessoa findByFluxoId(String fluxoId);
}
