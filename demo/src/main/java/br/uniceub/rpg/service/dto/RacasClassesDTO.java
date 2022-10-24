package br.uniceub.rpg.service.dto;

import br.uniceub.rpg.comum.entity.Classe;
import br.uniceub.rpg.comum.entity.Raca;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Builder
public class RacasClassesDTO {
    List<RacaDTO> racas;
    List<ClasseDTO> classes;

    //Construtor
    public RacasClassesDTO(List<Raca> racas, List<Classe> classes) {
        this.racas = new ArrayList<>();
        this.classes = new ArrayList<>();

        racas.forEach(r->{
            this.racas.add(new RacaDTO(r.getId(), r.getRaca(), r.getDescricao()));
        });

        classes.forEach(r->{
            this.classes.add(new ClasseDTO(r.getId(), r.getClasse()));
        });
    }
}
