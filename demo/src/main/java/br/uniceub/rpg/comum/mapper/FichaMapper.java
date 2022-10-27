package br.uniceub.rpg.comum.mapper;

import br.uniceub.rpg.comum.entity.Ficha;
import br.uniceub.rpg.service.dto.FichaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FichaMapper extends EntityMapper<FichaDTO, Ficha> {
}
