package br.uniceub.rpg.comum.mapper;

import br.uniceub.rpg.comum.entity.Usuario;
import org.mapstruct.Mapper;
import br.uniceub.rpg.service.dto.UsuarioDTO;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> {
}
