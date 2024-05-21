package br.uniceub.rpg.comum.mapper;

import br.uniceub.rpg.comum.entity.Raca;
import br.uniceub.rpg.service.dto.RacaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RacaMapper extends EntityMapper<RacaDTO, Raca> {
}
