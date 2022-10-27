package br.uniceub.rpg.service.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AntecedenteDTO {

    Long id;
    String antecedente;
    String descricao;
}
