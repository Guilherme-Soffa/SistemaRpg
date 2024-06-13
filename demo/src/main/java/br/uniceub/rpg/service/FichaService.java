package br.uniceub.rpg.service;

import br.uniceub.rpg.comum.entity.*;
import br.uniceub.rpg.comum.mapper.FichaMapper;
import br.uniceub.rpg.exception.RpgException;
import br.uniceub.rpg.service.dto.*;
import br.uniceub.rpg.service.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        var ficha = updateDataFicha(fichaDTO);
        return this.fichaRepository.save(ficha);
    }

    public Ficha atualizarFicha(FichaDTO fichaDTO){
        Ficha fichaBuscada = this.fichaRepository.findById(fichaDTO.getId()).get();
        var ficha = updateDataFicha(fichaDTO);
        ficha.setId(fichaBuscada.getId());
        ficha.setNotas(fichaBuscada.getNotas());
        ficha.setImagem(fichaBuscada.getImagem());
        return this.fichaRepository.save(ficha);
    }

    public FichaDTO findById(Long id){

        var ficha = this.fichaRepository.findById(id).get();


        FichaDTO fichaDTO = new FichaDTO();
        fichaDTO.setId(ficha.getId());
        AntecedenteDTO antecedenteDTO = new AntecedenteDTO();
        antecedenteDTO.setAntecedente(ficha.getAntecedente().getAntecedente());
        ClasseDTO classeDTO = new ClasseDTO();
        classeDTO.setClasse(ficha.getClasse().getClasse());
        OrigemDTO origemDTO = new OrigemDTO();
        origemDTO.setOrigem(ficha.getOrigem().getOrigem());
        RacaDTO racaDTO = new RacaDTO();
        racaDTO.setId(ficha.getRaca().getId());
        racaDTO.setRaca(ficha.getRaca().getRaca());
        NotasDTO notasDTO = new NotasDTO();
        notasDTO.setNotas(ficha.getNotas());

        fichaDTO.setAntecedente(antecedenteDTO);
        fichaDTO.setClasse(classeDTO);
        fichaDTO.setOrigem(origemDTO);
        fichaDTO.setRaca(racaDTO);
        fichaDTO.setPersonagem(ficha.getNomePersonagem());
        fichaDTO.setNotas(notasDTO);
        fichaDTO.setImagem(ficha.getImagem());
        return fichaDTO;
    }


    private Ficha updateDataFicha(FichaDTO fichaDTO){
        Ficha ficha = new Ficha();
        ficha.setIdAntecedente(fichaDTO.getAntecedente().getId());
        ficha.setIdClasse(fichaDTO.getClasse().getId());
        ficha.setIdOrigem(fichaDTO.getOrigem().getId());
        ficha.setIdUsuario(fichaDTO.getUsuario().getId());
        ficha.setIdRaca(fichaDTO.getRaca().getId());
        ficha.setNomePersonagem(fichaDTO.getPersonagem());
        return ficha;
    }
}
