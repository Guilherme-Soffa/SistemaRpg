package br.uniceub.rpg.service.dto;

import br.uniceub.rpg.comum.entity.Classe;
import br.uniceub.rpg.comum.entity.Raca;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RacasClassesDTO {
    List<RacaDTO> racas;
    List<ClasseDTO> classes;


    public static RacasClassesDTO toDTO(List<Raca> racas, List<Classe> classes){
        RacasClassesDTO racasClassesDTO = new RacasClassesDTO();

        List<RacaDTO> racasDTO = new ArrayList<>();
        List<ClasseDTO> classesDTO = new ArrayList<>();

        racas.forEach(r->{
            racasDTO.add(new RacaDTO(r.getId(), r.getRaca(), r.getDescricao()));
        });
        classes.forEach(r->{
            classesDTO.add(new ClasseDTO(r.getId(), r.getClasse(), r.getDescricao()));
        });

        racasClassesDTO.setRacas(racasDTO);
        racasClassesDTO.setClasses(classesDTO);

        return racasClassesDTO;
    }

}
