package service;

import comum.entity.Usuario;
import comum.mapper.UsuarioMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.dto.UsuarioDTO;

@Service
public class CadastrarUsuarioService{

    private service.CadastrarUsuarioRepository cadastrarUsuarioRepository;
    private UsuarioMapper UsuarioMapper;

    @Transactional
    public Usuario cadastrar(UsuarioDTO usuario){
        return this.cadastrarUsuarioRepository.save(this.UsuarioMapper.toEntity(usuario));
    }










}