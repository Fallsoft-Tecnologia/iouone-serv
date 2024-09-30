package br.com.iouone.repository;

import br.com.iouone.entity.Detox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetoxRepository extends JpaRepository<Detox, Integer> {
}