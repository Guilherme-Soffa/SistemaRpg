package br.uniceub.rpg.service.repository;

import br.uniceub.rpg.comum.entity.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AcompanhamentoRepository  extends JpaRepository<Ficha, Long> {

}
