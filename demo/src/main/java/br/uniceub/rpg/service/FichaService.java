package br.uniceub.rpg.service;

import br.uniceub.rpg.comum.entity.*;
import br.uniceub.rpg.comum.mapper.FichaMapper;
import br.uniceub.rpg.service.dto.FichaDTO;
import br.uniceub.rpg.service.dto.OrigemAntecedenteDTO;
import br.uniceub.rpg.service.dto.RacasClassesDTO;
import br.uniceub.rpg.service.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FichaService {

    private final RacaRepository racaRepository;
    private final ClasseRepository classeRepository;
    private final OrigemRepository origemRepository;
    private final AntecedenteRepository antecedenteRepository;
    private final FichaRepository fichaRepository;
    private final FichaMapper fichaMapper;

    public RacasClassesDTO buscarRacaClasse(){
        //Busca as informações no banco e retorna
        return RacasClassesDTO.toDTO(this.racaRepository.findAll(), this.classeRepository.findAll());
    };

    public OrigemAntecedenteDTO buscarOrigemAntecedente(Long idRaca, Long idClasse){
        return OrigemAntecedenteDTO.toDTO(this.origemRepository.buscarOrigens(idRaca,idClasse), this.antecedenteRepository.buscarAntecedentes(idRaca, idClasse));
    }

    public Ficha salvarFicha(FichaDTO fichaDTO){
        Ficha ficha = this.fichaMapper.toEntity(fichaDTO);
        ficha.setIdAntecedente(fichaDTO.getAntecedente().getId());
        ficha.setIdClasse(fichaDTO.getClasse().getId());
        ficha.setIdOrigem(fichaDTO.getOrigem().getId());
        ficha.setIdUsuario(fichaDTO.getUsuario().getId());
        ficha.setIdRaca(fichaDTO.getRaca().getId());
        ficha.setNomePersonagem(fichaDTO.getPersonagem());
        return this.fichaRepository.save(ficha);
    }
}
