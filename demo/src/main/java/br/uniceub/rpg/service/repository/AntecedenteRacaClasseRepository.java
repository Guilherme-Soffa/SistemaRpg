package br.uniceub.rpg.service.repository;

import br.uniceub.rpg.comum.entity.AntecedenteRacaClasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntecedenteRacaClasseRepository extends JpaRepository<AntecedenteRacaClasse, Long> {
}
