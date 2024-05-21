package br.uniceub.rpg.comum.mapper;

import br.uniceub.rpg.comum.entity.Origem;
import br.uniceub.rpg.service.dto.OrigemDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrigemMapper extends EntityMapper<OrigemDTO, Origem> {
}
