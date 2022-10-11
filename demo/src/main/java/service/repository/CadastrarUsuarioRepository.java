package service;

import comum.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.dto.UsuarioDTO;

@Service
public interface CadastrarUsuarioRepository extends JpaRepository<Usuario, Long> {



}