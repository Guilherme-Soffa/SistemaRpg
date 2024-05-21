package br.uniceub.rpg.controller;

import br.uniceub.rpg.service.AcompanhamentoService;
import br.uniceub.rpg.service.dto.DadosBancoDTO;
import br.uniceub.rpg.service.dto.FichaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class AcompanhamentoController {

    private final AcompanhamentoService acompanhamentoService;

    @GetMapping("buscar-fichas/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<FichaDTO>> buscarFichas(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.acompanhamentoService.buscar(id));
    };

    @GetMapping("buscar-dados-banco")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DadosBancoDTO> buscarDadosBanco(){
        return ResponseEntity.ok(this.acompanhamentoService.buscarDadosBanco());
    };

    @DeleteMapping("{id}")
    public void deletarSolicitacao(@PathVariable("id") Long id){
        this.acompanhamentoService.deletarFicha(id);
    }

}
