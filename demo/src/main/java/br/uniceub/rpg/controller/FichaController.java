package br.uniceub.rpg.controller;

import br.uniceub.rpg.comum.entity.Ficha;
import br.uniceub.rpg.service.FichaService;
import br.uniceub.rpg.service.dto.RacasClassesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
