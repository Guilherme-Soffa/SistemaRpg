package br.uniceub.rpg.comum.mapper;

import br.uniceub.rpg.comum.entity.Antecedente;
import br.uniceub.rpg.comum.entity.Classe;
import br.uniceub.rpg.service.dto.AntecedenteDTO;
import br.uniceub.rpg.service.dto.ClasseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClasseMapper extends EntityMapper<ClasseDTO, Classe> {
}
