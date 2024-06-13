package br.uniceub.rpg.comum.mapper;

import br.uniceub.rpg.comum.entity.Raca;
import br.uniceub.rpg.service.dto.RacaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RacaMapper extends EntityMapper<RacaDTO, Raca> {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "raca", target = "raca"),
            @Mapping(source = "descricao", target = "descricao")
    })
    RacaDTO toDto(Raca entity);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "raca", target = "raca"),
            @Mapping(source = "descricao", target = "descricao")
    })
    Raca toEntity(RacaDTO dto);
}
