package br.uniceub.rpg.service.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AntecedenteDTOTest {

    @Test
    void testGettersAndSetters() {
        AntecedenteDTO dto = new AntecedenteDTO();
        dto.setId(1L);
        dto.setAntecedente("Antecedente");
        dto.setDescricao("Descricao");

        assertEquals(1L, dto.getId());
        assertEquals("Antecedente", dto.getAntecedente());
        assertEquals("Descricao", dto.getDescricao());
    }

    @Test
    void testBuilder() {
        AntecedenteDTO dto = AntecedenteDTO.builder()
                .id(1L)
                .antecedente("Antecedente")
                .descricao("Descricao")
                .build();

        assertEquals(1L, dto.getId());
        assertEquals("Antecedente", dto.getAntecedente());
        assertEquals("Descricao", dto.getDescricao());
    }

    @Test
    void testNoArgsConstructor() {
        AntecedenteDTO dto = new AntecedenteDTO();
        assertNotNull(dto);
    }

    @Test
    void testAllArgsConstructor() {
        AntecedenteDTO dto = new AntecedenteDTO(1L, "Antecedente", "Descricao");
        assertEquals(1L, dto.getId());
        assertEquals("Antecedente", dto.getAntecedente());
        assertEquals("Descricao", dto.getDescricao());
    }
}