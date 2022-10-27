package br.uniceub.rpg.service.repository;

import br.uniceub.rpg.comum.entity.Antecedente;
import br.uniceub.rpg.comum.entity.Origem;
import br.uniceub.rpg.comum.entity.Raca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AntecedenteRepository extends JpaRepository<Antecedente, Long> {


    @Query("select antec from Antecedente antec join AntecedenteRacaClasse agrc on antec.id = agrc.idAntecedente where agrc.idRaca = :idRaca and agrc.idClasse = :idClasse")
    List<Antecedente> buscarAntecedentes(@Param("idRaca")Long idRaca, @Param("idClasse")Long idClasse);
}
