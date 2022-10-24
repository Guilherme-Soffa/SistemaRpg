package br.uniceub.rpg.service.repository;

import br.uniceub.rpg.comum.entity.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe,Long> {
}
