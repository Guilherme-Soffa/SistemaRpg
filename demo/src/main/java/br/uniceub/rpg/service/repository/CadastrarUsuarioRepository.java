package br.uniceub.rpg.service.repository;

import br.uniceub.rpg.comum.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastrarUsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select u from Usuario u where u.usuario = :usuario and u.password = :password")
    Usuario buscaLogin(@Param("usuario")String usuario, @Param("password")String password);



}