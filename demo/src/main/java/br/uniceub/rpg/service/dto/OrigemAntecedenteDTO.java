package br.uniceub.rpg.service.dto;

import br.uniceub.rpg.comum.entity.Antecedente;
import br.uniceub.rpg.comum.entity.Origem;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrigemAntecedenteDTO {
    List<OrigemDTO> origens;
    List<AntecedenteDTO> antecedentes;


    public static OrigemAntecedenteDTO toDTO(List<Origem> origens, List<Antecedente> antecedentes){
        OrigemAntecedenteDTO origemAntecedenteDTO = new OrigemAntecedenteDTO();

        List<OrigemDTO> origensDTO = new ArrayList<>();
        List<AntecedenteDTO> antecedentesDTO = new ArrayList<>();

        origens.forEach(r->{
            origensDTO.add(new OrigemDTO(r.getId(), r.getOrigem(), r.getDescricao()));
        });
        antecedentes.forEach(r->{
            antecedentesDTO.add(new AntecedenteDTO(r.getId(), r.getAntecedente(), r.getDescricao()));
        });

        origemAntecedenteDTO.setOrigens(origensDTO);
        origemAntecedenteDTO.setAntecedentes(antecedentesDTO);

        return origemAntecedenteDTO;
    }
}
