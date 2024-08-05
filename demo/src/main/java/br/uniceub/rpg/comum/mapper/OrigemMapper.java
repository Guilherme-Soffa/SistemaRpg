package br.uniceub.rpg.comum.mapper;

import br.uniceub.rpg.comum.entity.Origem;
import br.uniceub.rpg.service.dto.OrigemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OrigemMapper extends EntityMapper<OrigemDTO, Origem> {
//
//    @Mappings({
//            @Mapping(source = "id", target = "id"),
//            @Mapping(source = "origem", target = "origem"),
//            @Mapping(source = "descricao", target = "descricao")
//    })
//    OrigemDTO toDto(Origem entity);
//
//    @Mappings({
//            @Mapping(source = "id", target = "id"),
//            @Mapping(source = "origem", target = "origem"),
//            @Mapping(source = "descricao", target = "descricao")
//    })
//    Origem toEntity(OrigemDTO dto);
}
