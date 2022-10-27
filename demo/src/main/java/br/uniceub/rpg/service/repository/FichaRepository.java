package br.uniceub.rpg.service.repository;

import br.uniceub.rpg.comum.entity.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FichaRepository extends JpaRepository<Ficha, Long> {


    @Query("select ficha from Ficha ficha where ficha.idUsuario = :idUsuario")
    List<Ficha> buscarPorIdUsuario(@Param("idUsuario")Long idUsuario);
}
