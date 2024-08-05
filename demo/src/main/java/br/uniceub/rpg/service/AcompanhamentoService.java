package br.uniceub.rpg.service;

import br.uniceub.rpg.comum.entity.Ficha;
import br.uniceub.rpg.comum.exception.NegocioException;
import br.uniceub.rpg.comum.mapper.*;
import br.uniceub.rpg.exception.RpgException;
import br.uniceub.rpg.service.dto.*;
//import br.uniceub.rpg.service.repository.AcompanhamentoRepository;
import br.uniceub.rpg.service.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

    public List<FichaDTO> buscar(Long id){
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
            NotasDTO notasDTO = new NotasDTO();
            notasDTO.setNotas(ficha.getNotas());

             fichaDTO.setAntecedente(antecedenteDTO);
             fichaDTO.setClasse(classeDTO);
             fichaDTO.setOrigem(origemDTO);
             fichaDTO.setRaca(racaDTO);
             fichaDTO.setPersonagem(ficha.getNomePersonagem());
             fichaDTO.setNotas(notasDTO);
             fichaDTO.setImagem(ficha.getImagem());
             fichasDTO.add(fichaDTO);
        });

        if(!fichasDTO.isEmpty()){
            return fichasDTO;
        }else {
            throw new RpgException("Nenhuma ficha encontrada!");
        }
    }

    public NotasDTO salvarNotas(NotasDTO notasDTO){
        Ficha ficha = this.fichaRepository.findById(notasDTO.getId()).orElseThrow(() -> new RpgException("Ficha não encontrada!"));
        ficha.setNotas(notasDTO.getNotas());
        this.fichaRepository.save(ficha);
        return notasDTO;
    }

    public void saveImage(Long id, MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            Ficha acompanhamento = fichaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Acompanhamento not found with id: " + id));
            acompanhamento.setImagem(bytes);
            fichaRepository.save(acompanhamento);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }

    public NotasDTO buscarNotas(Long id){
        Ficha ficha = this.fichaRepository.findById(id).orElseThrow(() -> new RpgException("Ficha não encontrada!"));
        NotasDTO notas = new NotasDTO();
        notas.setNotas(ficha.getNotas());
        return notas;
    }

    public DadosBancoDTO buscarDadosBanco(){

        DadosBancoDTO dadosDTO = new DadosBancoDTO();
//        List<AntecedenteDTO> antecedenteDTO = this.antecedenteMapper.toDto(this.antecedenteRepository.findAll());
//        List<ClasseDTO> classeDTO = this.classeMapper.toDto(this.classeRepository.findAll());
//        List<OrigemDTO> origemDTO = this.origemMapper.toDto(this.origemRepository.findAll());
//        List<RacaDTO> racaDTO = this.racaMapper.toDto(this.racaRepository.findAll());
//
//        dadosDTO.setAntecedente(antecedenteDTO);
//        dadosDTO.setClasse(classeDTO);
//        dadosDTO.setOrigem(origemDTO);
//        dadosDTO.setRaca(racaDTO);

        return dadosDTO;
    }

    public void deletarFicha(Long id){
        this.fichaRepository.deleteById(id);
    }
}
