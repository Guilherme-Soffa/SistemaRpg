package br.uniceub.rpg.service.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FichaDTO {
    String personagem;
    String classe;
    String raca;
    String origem;
    String antecedente;
}
