package br.uniceub.rpg.service.repository;

import br.uniceub.rpg.comum.entity.Raca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacaRepository extends JpaRepository<Raca,Long> {
}
