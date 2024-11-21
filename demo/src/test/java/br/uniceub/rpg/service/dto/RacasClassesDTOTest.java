package br.uniceub.rpg.service.dto;

import br.uniceub.rpg.comum.entity.Classe;
import br.uniceub.rpg.comum.entity.Raca;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacasClassesDTOTest {

    @Test
    void testToDTO() {
        Raca raca = new Raca(1L, "Raca1", "Descricao1");
        Classe classe = new Classe(1L, "Classe1", "Descricao1");

        List<Raca> racas = Arrays.asList(raca);
        List<Classe> classes = Arrays.asList(classe);

        RacasClassesDTO dto = RacasClassesDTO.toDTO(racas, classes);

        assertNotNull(dto);
        assertEquals(1, dto.getRacas().size());
        assertEquals(1, dto.getClasses().size());
        assertEquals("Raca1", dto.getRacas().get(0).getRaca());
        assertEquals("Classe1", dto.getClasses().get(0).getClasse());
    }
}