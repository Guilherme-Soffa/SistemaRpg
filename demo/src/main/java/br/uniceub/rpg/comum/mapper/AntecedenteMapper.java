package br.uniceub.rpg.comum.mapper;

import br.uniceub.rpg.comum.entity.Antecedente;
import br.uniceub.rpg.service.dto.AntecedenteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AntecedenteMapper extends EntityMapper<AntecedenteDTO, Antecedente> {
}
