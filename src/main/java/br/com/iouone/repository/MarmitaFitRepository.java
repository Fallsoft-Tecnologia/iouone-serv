package br.com.iouone.repository;

import br.com.iouone.entity.MarmitaFit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarmitaFitRepository extends JpaRepository<MarmitaFit, Integer> {

    @Query(value = "SELECT mf.id AS idMarmita, mf.nome AS nome, mf.modo_de_preparo AS modoDePreparo, " +
            "mf.foto AS foto, mf.descricao AS descricao, " +
            "i.nome AS nomeIngrediente, rmf.quantidade, " +
            "um.unidade_de_medida AS unidadeDeMedida " +
            "FROM marmita_fit mf " +
            "LEFT JOIN receita_marmita_fit rmf ON mf.id = rmf.id_marmita_fit " +
            "LEFT JOIN ingredientes i ON i.id = rmf.id_ingredientes " +
            "LEFT JOIN unidade_de_medida um ON um.id = rmf.id_unidade_de_medida " +
            "WHERE mf.id = ?1", nativeQuery = true)
    List<Object[]> findMarmitaFitWithIngredientsNative(Integer id);

}
