package br.uniceub.rpg.controller;

import br.uniceub.rpg.comum.entity.Ficha;
import br.uniceub.rpg.service.FichaService;
import br.uniceub.rpg.service.dto.FichaDTO;
import br.uniceub.rpg.service.dto.OrigemAntecedenteDTO;
import br.uniceub.rpg.service.dto.RacasClassesDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class FichaControllerTest {

    @Mock
    private FichaService fichaService;

    @InjectMocks
    private FichaController fichaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarRacaClasse() {
        RacasClassesDTO racasClassesDTO = new RacasClassesDTO();
        when(fichaService.buscarRacaClasse()).thenReturn(racasClassesDTO);

        ResponseEntity<RacasClassesDTO> response = fichaController.buscarRacaClasse();

        assertEquals(ResponseEntity.ok(racasClassesDTO), response);
        verify(fichaService, times(1)).buscarRacaClasse();
    }

    @Test
    void buscarOrigemAntecedente() {
        OrigemAntecedenteDTO origemAntecedenteDTO = new OrigemAntecedenteDTO();
        when(fichaService.buscarOrigemAntecedente(anyLong(), anyLong())).thenReturn(origemAntecedenteDTO);

        ResponseEntity<OrigemAntecedenteDTO> response = fichaController.buscarOrigemAntecedente(1L, 1L);

        assertEquals(ResponseEntity.ok(origemAntecedenteDTO), response);
        verify(fichaService, times(1)).buscarOrigemAntecedente(1L, 1L);
    }

    @Test
    void cadastrarFicha() {
        Ficha ficha = new Ficha();
        when(fichaService.salvarFicha(any(FichaDTO.class))).thenReturn(ficha);

        ResponseEntity<Ficha> response = fichaController.cadastrarFicha(new FichaDTO());

        assertEquals(ResponseEntity.ok(ficha), response);
        verify(fichaService, times(1)).salvarFicha(any(FichaDTO.class));
    }

    @Test
    void atualizarFicha() {
        Ficha ficha = new Ficha();
        when(fichaService.atualizarFicha(any(FichaDTO.class))).thenReturn(ficha);

        ResponseEntity<Ficha> response = fichaController.atualizarFicha(new FichaDTO());

        assertEquals(ResponseEntity.ok(ficha), response);
        verify(fichaService, times(1)).atualizarFicha(any(FichaDTO.class));
    }

    @Test
    void buscarFicha() {
        FichaDTO fichaDTO = new FichaDTO();
        when(fichaService.findById(anyLong())).thenReturn(fichaDTO);

        ResponseEntity<FichaDTO> response = fichaController.buscarOrigemAntecedente(1L);

        assertEquals(ResponseEntity.ok(fichaDTO), response);
        verify(fichaService, times(1)).findById(1L);
    }
}