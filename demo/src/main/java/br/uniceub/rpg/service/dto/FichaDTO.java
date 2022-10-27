package br.uniceub.rpg.service.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FichaDTO {
    UsuarioDTO usuario;
    String personagem;
    ClasseDTO classe;
    RacaDTO raca;
    OrigemDTO origem;
    AntecedenteDTO antecedente;
}
