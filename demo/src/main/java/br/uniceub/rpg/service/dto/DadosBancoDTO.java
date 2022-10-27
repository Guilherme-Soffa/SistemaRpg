package br.uniceub.rpg.service.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DadosBancoDTO {
    List<UsuarioDTO> usuario;
    List<String> personagem;
    List<ClasseDTO> classe;
    List<RacaDTO> raca;
    List<OrigemDTO> origem;
    List<AntecedenteDTO> antecedente;
}
