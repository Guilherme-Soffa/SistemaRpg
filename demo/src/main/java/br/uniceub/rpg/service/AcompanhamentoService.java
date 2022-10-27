package br.uniceub.rpg.service;

import br.uniceub.rpg.comum.entity.Ficha;
import br.uniceub.rpg.comum.entity.Usuario;
import br.uniceub.rpg.comum.exception.NegocioException;
import br.uniceub.rpg.comum.mapper.*;
import br.uniceub.rpg.service.dto.*;
//import br.uniceub.rpg.service.repository.AcompanhamentoRepository;
import br.uniceub.rpg.service.repository.AcompanhamentoRepository;
import br.uniceub.rpg.service.repository.FichaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AcompanhamentoService{

    private final FichaRepository fichaRepository;
    private final FichaMapper fichaMapper;
    private final AntecedenteMapper antecedenteMapper;
    private final OrigemMapper origemMapper;
    private final RacaMapper racaMapper;
    private final ClasseMapper classeMapper;

    public List<FichaDTO> Buscar(Long id){
        //Busca as fichas cadastradas
        List<Ficha> fichas = this.fichaRepository.buscarPorIdUsuario(id);

        List<FichaDTO> fichasDTO = new ArrayList<>();
        fichas.forEach(ficha -> {
            FichaDTO fichaDTO = new FichaDTO();
            AntecedenteDTO antecedenteDTO = this.antecedenteMapper.toDto(ficha.getAntecedente());
            ClasseDTO classeDTO = this.classeMapper.toDto(ficha.getClasse());
            OrigemDTO origemDTO = this.origemMapper.toDto(ficha.getOrigem());
            RacaDTO racaDTO = this.racaMapper.toDto(ficha.getRaca());

             fichaDTO.setAntecedente(antecedenteDTO);
             fichaDTO.setClasse(classeDTO);
             fichaDTO.setOrigem(origemDTO);
             fichaDTO.setRaca(racaDTO);
//             fichaDTO.setPersonagem();
            fichasDTO.add(fichaDTO);
        });

        if(fichasDTO.size() > 0){
            return fichasDTO;
        }else {
            throw new NegocioException(this.getClass().getName(), "Nenhuma ficha encontrada!");
        }
    }
}
