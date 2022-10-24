package br.uniceub.rpg.service;

import br.uniceub.rpg.service.dto.RacasClassesDTO;
import br.uniceub.rpg.service.repository.ClasseRepository;
import br.uniceub.rpg.service.repository.RacaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FichaService {

    private final RacaRepository racaRepository;
    private final ClasseRepository classeRepository;

    public RacasClassesDTO buscarRacaClasse(){
        //Busca as informações no banco e retorna
//        return new RacasClassesDTO(this.racaRepository.findAll(), this.classeRepository.findAll());
        return null;
    };
}
