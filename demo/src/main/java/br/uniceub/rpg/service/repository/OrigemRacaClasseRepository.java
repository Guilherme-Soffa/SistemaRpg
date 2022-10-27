package br.uniceub.rpg.service.repository;

import br.uniceub.rpg.comum.entity.OrigemRacaClasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrigemRacaClasseRepository extends JpaRepository<OrigemRacaClasse, Long> {
}
