package br.uniceub.rpg.service;

import br.uniceub.rpg.comum.entity.Usuario;
import br.uniceub.rpg.comum.exception.NegocioException;
import br.uniceub.rpg.exception.RpgException;
import br.uniceub.rpg.service.repository.CadastrarUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.uniceub.rpg.service.dto.UsuarioDTO;

@Service
@RequiredArgsConstructor
public class CadastrarUsuarioService{

    private final CadastrarUsuarioRepository cadastrarUsuarioRepository;


    @Transactional
    public Usuario cadastrar(UsuarioDTO usuario){
        Usuario usuarioSalvo = new Usuario();
        usuarioSalvo.setUsuario(usuario.getUsuario());
        usuarioSalvo.setPassword(usuario.getPassword());
        return this.cadastrarUsuarioRepository.save(usuarioSalvo);
    }

    public Usuario login(String usuario, String password){
        Usuario usuarioBuscado = this.cadastrarUsuarioRepository.buscaLogin(usuario,password);
        if(usuarioBuscado != null){
            return usuarioBuscado;
        }else{
            throw new RpgException("Usuario não encontrado");
        }
    }

    public Usuario buscar(Long id){
        return this.cadastrarUsuarioRepository.findById(id).get();
    }

    public Usuario editar(UsuarioDTO usuario){
        Usuario usuarioSalvo = this.cadastrarUsuarioRepository.findById(usuario.getId()).get();
        usuarioSalvo.setUsuario(usuario.getUsuario());
        usuarioSalvo.setPassword(usuario.getPassword());
        return this.cadastrarUsuarioRepository.save(usuarioSalvo);
    }

}