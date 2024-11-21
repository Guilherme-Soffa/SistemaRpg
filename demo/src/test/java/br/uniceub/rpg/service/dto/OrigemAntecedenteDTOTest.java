package br.uniceub.rpg.service.dto;

import br.uniceub.rpg.comum.entity.Antecedente;
import br.uniceub.rpg.comum.entity.Origem;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrigemAntecedenteDTOTest {

    @Test
    void testToDTO() {
        Origem origem = new Origem(1L, "Origem1", "Descricao1");
        Antecedente antecedente = new Antecedente(1L, "Antecedente1", "Descricao1");

        List<Origem> origens = Arrays.asList(origem);
        List<Antecedente> antecedentes = Arrays.asList(antecedente);

        OrigemAntecedenteDTO dto = OrigemAntecedenteDTO.toDTO(origens, antecedentes);

        assertNotNull(dto);
        assertEquals(1, dto.getOrigens().size());
        assertEquals(1, dto.getAntecedentes().size());
        assertEquals("Origem1", dto.getOrigens().get(0).getOrigem());
        assertEquals("Antecedente1", dto.getAntecedentes().get(0).getAntecedente());
    }
}