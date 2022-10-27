package br.uniceub.rpg.service.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrigemDTO {
    Long id;
    String origem;
    String descricao;
}
