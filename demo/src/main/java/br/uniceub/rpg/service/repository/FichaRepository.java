package br.uniceub.rpg.service.repository;

import br.uniceub.rpg.comum.entity.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FichaRepository extends JpaRepository<Ficha, Long> {

}
