package br.com.iouone.repository;

import br.com.iouone.entity.Musculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusculoRepository extends JpaRepository<Musculo, Integer> {
}