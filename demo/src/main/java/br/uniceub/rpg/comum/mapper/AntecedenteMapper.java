package br.uniceub.rpg.comum.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import br.uniceub.rpg.comum.entity.Antecedente;
import br.uniceub.rpg.service.dto.AntecedenteDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AntecedenteMapper {
//    @Mappings({
//            @Mapping(source = "id", target = "id"),
//            @Mapping(source = "antecedente", target = "antecedente"),
//            @Mapping(source = "descricao", target = "descricao")
//    })
//    AntecedenteDTO toDto(Antecedente entity);
//
//    @Mappings({
//            @Mapping(source = "id", target = "id"),
//            @Mapping(source = "antecedente", target = "antecedente"),
//            @Mapping(source = "descricao", target = "descricao")
//    })
//    Antecedente toEntity(AntecedenteDTO dto);
//
//    List<Antecedente> toEntity(List<AntecedenteDTO> dtoList);
//    List<AntecedenteDTO> toDto(List<Antecedente> entityList);
}