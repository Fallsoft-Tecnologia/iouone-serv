package br.com.iouone.repository;

import br.com.iouone.entity.Paises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Paises, Integer> {

    Paises findByAbreviacao(String abreviacao);
}
