package br.uniceub.rpg.controller;

import br.uniceub.rpg.comum.entity.Ficha;
import br.uniceub.rpg.service.FichaService;
import br.uniceub.rpg.service.dto.FichaDTO;
import br.uniceub.rpg.service.dto.OrigemAntecedenteDTO;
import br.uniceub.rpg.service.dto.RacasClassesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class FichaController {

    private final FichaService fichaService;

    @GetMapping("buscar-raca-classe")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<RacasClassesDTO> buscarRacaClasse(){
        return ResponseEntity.ok(this.fichaService.buscarRacaClasse());
    };

    @GetMapping("buscar-origem-antecedente/{idRaca}/{idClasse}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<OrigemAntecedenteDTO> buscarOrigemAntecedente(@PathVariable Long idRaca, @PathVariable Long idClasse){
        return ResponseEntity.ok(this.fichaService.buscarOrigemAntecedente(idRaca,idClasse));
    };

    @PostMapping("cadastrar-ficha")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Ficha> cadastrarFicha(@RequestBody FichaDTO fichaDTO){
        return ResponseEntity.ok(this.fichaService.salvarFicha(fichaDTO));
    }

    @PostMapping("atualizar-ficha")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Ficha> atualizarFicha(@RequestBody FichaDTO fichaDTO){
        return ResponseEntity.ok(this.fichaService.atualizarFicha(fichaDTO));
    }

    @GetMapping("buscar-ficha/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<FichaDTO> buscarOrigemAntecedente(@PathVariable Long id){
        return ResponseEntity.ok(this.fichaService.findById(id));
    };
}
