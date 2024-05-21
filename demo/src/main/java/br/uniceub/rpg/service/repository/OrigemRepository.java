package br.uniceub.rpg.service.repository;

import br.uniceub.rpg.comum.entity.Origem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrigemRepository extends JpaRepository<Origem, Long> {

    @Query("select og from Origem og join OrigemRacaClasse ogrc on og.id = ogrc.idOrigem where ogrc.idRaca = :idRaca and ogrc.idClasse = :idClasse")
    List<Origem> buscarOrigens(@Param("idRaca")Long idRaca, @Param("idClasse")Long idClasse);
}
