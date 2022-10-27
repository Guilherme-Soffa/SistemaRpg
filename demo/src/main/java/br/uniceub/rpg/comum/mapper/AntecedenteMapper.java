package br.uniceub.rpg.comum.mapper;

import br.uniceub.rpg.comum.entity.Antecedente;
import br.uniceub.rpg.comum.entity.Ficha;
import br.uniceub.rpg.service.dto.AntecedenteDTO;
import br.uniceub.rpg.service.dto.FichaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AntecedenteMapper extends EntityMapper<AntecedenteDTO, Antecedente> {
}
