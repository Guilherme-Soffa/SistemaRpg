package br.uniceub.rpg.service.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FichaDTO {
    Long id;
    UsuarioDTO usuario;
    String personagem;
    ClasseDTO classe;
    RacaDTO raca;
    OrigemDTO origem;
    AntecedenteDTO antecedente;
    NotasDTO notas;
}
