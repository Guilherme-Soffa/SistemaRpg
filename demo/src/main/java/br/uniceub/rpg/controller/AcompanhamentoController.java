package br.uniceub.rpg.controller;

import br.uniceub.rpg.comum.entity.Ficha;
import br.uniceub.rpg.comum.entity.Usuario;
import br.uniceub.rpg.service.AcompanhamentoService;
import br.uniceub.rpg.service.dto.DadosBancoDTO;
import br.uniceub.rpg.service.dto.FichaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class AcompanhamentoController {

    private final AcompanhamentoService acompanhamentoService;

    @GetMapping("buscar-fichas/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<FichaDTO>> buscarFichas(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.acompanhamentoService.Buscar(id));
    };

    @GetMapping("buscar-dados-banco")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DadosBancoDTO> buscarDadosBanco(){
        return ResponseEntity.ok(this.acompanhamentoService.BuscarDadosBanco());
    };

}
