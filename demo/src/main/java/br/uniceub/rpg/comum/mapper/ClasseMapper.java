package br.uniceub.rpg.comum.mapper;

import br.uniceub.rpg.comum.entity.Antecedente;
import br.uniceub.rpg.comum.entity.Classe;
import br.uniceub.rpg.service.dto.AntecedenteDTO;
import br.uniceub.rpg.service.dto.ClasseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ClasseMapper extends EntityMapper<ClasseDTO, Classe> {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "classe", target = "classe"),
            @Mapping(source = "descricao", target = "descricao")
    })
    ClasseDTO toDto(Classe entity);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "classe", target = "classe"),
            @Mapping(source = "descricao", target = "descricao")
    })
    Classe toEntity(ClasseDTO dto);
}
