package br.uniceub.rpg.service;

import br.uniceub.rpg.comum.entity.Ficha;
import br.uniceub.rpg.comum.entity.Usuario;
import br.uniceub.rpg.comum.exception.NegocioException;
import br.uniceub.rpg.comum.mapper.*;
import br.uniceub.rpg.service.dto.*;
//import br.uniceub.rpg.service.repository.AcompanhamentoRepository;
import br.uniceub.rpg.service.repository.*;
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

    private final AntecedenteRepository antecedenteRepository;
    private final ClasseRepository classeRepository;
    private final OrigemRepository origemRepository;
    private final RacaRepository racaRepository;

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
            fichaDTO.setId(ficha.getId());
            AntecedenteDTO antecedenteDTO = new AntecedenteDTO();
            antecedenteDTO.setAntecedente(ficha.getAntecedente().getAntecedente());
            ClasseDTO classeDTO = new ClasseDTO();
            classeDTO.setClasse(ficha.getClasse().getClasse());
            OrigemDTO origemDTO = new OrigemDTO();
            origemDTO.setOrigem(ficha.getOrigem().getOrigem());
            RacaDTO racaDTO = new RacaDTO();
            racaDTO.setRaca(ficha.getRaca().getRaca());

             fichaDTO.setAntecedente(antecedenteDTO);
             fichaDTO.setClasse(classeDTO);
             fichaDTO.setOrigem(origemDTO);
             fichaDTO.setRaca(racaDTO);
             fichaDTO.setPersonagem(ficha.getNomePersonagem());
             fichasDTO.add(fichaDTO);
        });

        if(fichasDTO.size() > 0){
            return fichasDTO;
        }else {
            throw new NegocioException(this.getClass().getName(), "Nenhuma ficha encontrada!");
        }
    }

    public DadosBancoDTO BuscarDadosBanco(){

        DadosBancoDTO dadosDTO = new DadosBancoDTO();
        List<AntecedenteDTO> antecedenteDTO = this.antecedenteMapper.toDto(this.antecedenteRepository.findAll());
        List<ClasseDTO> classeDTO = this.classeMapper.toDto(this.classeRepository.findAll());
        List<OrigemDTO> origemDTO = this.origemMapper.toDto(this.origemRepository.findAll());
        List<RacaDTO> racaDTO = this.racaMapper.toDto(this.racaRepository.findAll());

        dadosDTO.setAntecedente(antecedenteDTO);
        dadosDTO.setClasse(classeDTO);
        dadosDTO.setOrigem(origemDTO);
        dadosDTO.setRaca(racaDTO);

        return dadosDTO;
    }

    public void DeletarFicha(Long id){
        this.fichaRepository.deleteById(id);
    }
}
