package br.com.iouone.repository;

import br.com.iouone.entity.Biotipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BiotipoRepository extends JpaRepository<Biotipo, Integer> {
}