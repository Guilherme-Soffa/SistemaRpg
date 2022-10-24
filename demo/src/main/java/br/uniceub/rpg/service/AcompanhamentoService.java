package br.uniceub.rpg.service;

import br.uniceub.rpg.comum.entity.Ficha;
import br.uniceub.rpg.comum.entity.Usuario;
import br.uniceub.rpg.comum.exception.NegocioException;
import br.uniceub.rpg.service.dto.FichaDTO;
//import br.uniceub.rpg.service.repository.AcompanhamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AcompanhamentoService{

//    private AcompanhamentoRepository acompanhamentoRepository;

    public Ficha Buscar(Long id){
//        Optional<Ficha> fichaBuscada = this.acompanhamentoRepository.findById(id);
//        FichaDTO fichaDTO = new FichaDTO();
//        Ficha ficha = fichaBuscada.get();
//
//        fichaDTO.setAntecedente(ficha.getAntecedente());
//        fichaDTO.setClasse(ficha.getClasse());
//        fichaDTO.setOrigem()
//        if(fichaBuscada != null){
//            return fichaBuscada;
//        }else{
//            throw new NegocioException(this.getClass().getName(), "Usuario não encontrado");
//        }
        return null;
    }
}
