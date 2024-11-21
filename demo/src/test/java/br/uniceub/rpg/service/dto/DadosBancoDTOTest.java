package br.uniceub.rpg.service.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DadosBancoDTOTest {

    @Mock
    private List<UsuarioDTO> mockUsuarios;

    @Mock
    private List<String> mockPersonagens;

    @Mock
    private List<ClasseDTO> mockClasses;

    @Mock
    private List<RacaDTO> mockRacas;

    @Mock
    private List<OrigemDTO> mockOrigens;

    @Mock
    private List<AntecedenteDTO> mockAntecedentes;

    @InjectMocks
    private DadosBancoDTO dadosBancoDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGettersAndSetters() {
        dadosBancoDTO.setUsuario(mockUsuarios);
        dadosBancoDTO.setPersonagem(mockPersonagens);
        dadosBancoDTO.setClasse(mockClasses);
        dadosBancoDTO.setRaca(mockRacas);
        dadosBancoDTO.setOrigem(mockOrigens);
        dadosBancoDTO.setAntecedente(mockAntecedentes);

        assertEquals(mockUsuarios, dadosBancoDTO.getUsuario());
        assertEquals(mockPersonagens, dadosBancoDTO.getPersonagem());
        assertEquals(mockClasses, dadosBancoDTO.getClasse());
        assertEquals(mockRacas, dadosBancoDTO.getRaca());
        assertEquals(mockOrigens, dadosBancoDTO.getOrigem());
        assertEquals(mockAntecedentes, dadosBancoDTO.getAntecedente());
    }

    @Test
    void testBuilder() {
        DadosBancoDTO dto = DadosBancoDTO.builder()
                .usuario(mockUsuarios)
                .personagem(mockPersonagens)
                .classe(mockClasses)
                .raca(mockRacas)
                .origem(mockOrigens)
                .antecedente(mockAntecedentes)
                .build();

        assertEquals(mockUsuarios, dto.getUsuario());
        assertEquals(mockPersonagens, dto.getPersonagem());
        assertEquals(mockClasses, dto.getClasse());
        assertEquals(mockRacas, dto.getRaca());
        assertEquals(mockOrigens, dto.getOrigem());
        assertEquals(mockAntecedentes, dto.getAntecedente());
    }
}