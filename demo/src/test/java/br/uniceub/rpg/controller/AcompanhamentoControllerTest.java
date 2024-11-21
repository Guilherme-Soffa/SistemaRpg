package br.uniceub.rpg.controller;

import br.uniceub.rpg.service.AcompanhamentoService;
import br.uniceub.rpg.service.dto.DadosBancoDTO;
import br.uniceub.rpg.service.dto.FichaDTO;
import br.uniceub.rpg.service.dto.NotasDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class AcompanhamentoControllerTest {

    @Mock
    private AcompanhamentoService acompanhamentoService;

    @InjectMocks
    private AcompanhamentoController acompanhamentoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarFichas() {
        List<FichaDTO> fichas = List.of(new FichaDTO());
        when(acompanhamentoService.buscar(anyLong())).thenReturn(fichas);

        ResponseEntity<List<FichaDTO>> response = acompanhamentoController.buscarFichas(1L);

        assertEquals(ResponseEntity.ok(fichas), response);
        verify(acompanhamentoService, times(1)).buscar(1L);
    }

    @Test
    void buscarDadosBanco() {
        DadosBancoDTO dadosBancoDTO = new DadosBancoDTO();
        when(acompanhamentoService.buscarDadosBanco()).thenReturn(dadosBancoDTO);

        ResponseEntity<DadosBancoDTO> response = acompanhamentoController.buscarDadosBanco();

        assertEquals(ResponseEntity.ok(dadosBancoDTO), response);
        verify(acompanhamentoService, times(1)).buscarDadosBanco();
    }

    @Test
    void deletarSolicitacao() {
        doNothing().when(acompanhamentoService).deletarFicha(anyLong());

        acompanhamentoController.deletarSolicitacao(1L);

        verify(acompanhamentoService, times(1)).deletarFicha(1L);
    }

    @Test
    void salvarNotas() {
        NotasDTO notasDTO = new NotasDTO();
        when(acompanhamentoService.salvarNotas(any(NotasDTO.class))).thenReturn(notasDTO);

        ResponseEntity<NotasDTO> response = acompanhamentoController.buscarFichas(notasDTO);

        assertEquals(ResponseEntity.ok(notasDTO), response);
        verify(acompanhamentoService, times(1)).salvarNotas(notasDTO);
    }

    @Test
    void buscarNotas() {
        NotasDTO notasDTO = new NotasDTO();
        when(acompanhamentoService.buscarNotas(anyLong())).thenReturn(notasDTO);

        ResponseEntity<NotasDTO> response = acompanhamentoController.buscarNotas(1L);

        assertEquals(ResponseEntity.ok(notasDTO), response);
        verify(acompanhamentoService, times(1)).buscarNotas(1L);
    }

    @Test
    void uploadImage() {
        MultipartFile file = mock(MultipartFile.class);
        doNothing().when(acompanhamentoService).saveImage(anyLong(), any(MultipartFile.class));

        acompanhamentoController.uploadImage(1L, file);

        verify(acompanhamentoService, times(1)).saveImage(1L, file);
    }
}