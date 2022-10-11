package comum.mapper;

import comum.entity.Usuario;
import org.mapstruct.Mapper;
import service.dto.UsuarioDTO;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> {
}
