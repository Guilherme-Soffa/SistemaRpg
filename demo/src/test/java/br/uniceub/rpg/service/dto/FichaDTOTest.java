package br.uniceub.rpg.service.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FichaDTOTest {

    @Test
    void testGettersAndSetters() {
        FichaDTO dto = new FichaDTO();
        UsuarioDTO usuario = new UsuarioDTO();
        ClasseDTO classe = new ClasseDTO();
        RacaDTO raca = new RacaDTO();
        OrigemDTO origem = new OrigemDTO();
        AntecedenteDTO antecedente = new AntecedenteDTO();
        NotasDTO notas = new NotasDTO();
        byte[] imagem = new byte[]{1, 2, 3};

        dto.setId(1L);
        dto.setUsuario(usuario);
        dto.setPersonagem("Personagem");
        dto.setClasse(classe);
        dto.setRaca(raca);
        dto.setOrigem(origem);
        dto.setAntecedente(antecedente);
        dto.setNotas(notas);
        dto.setImagem(imagem);

        assertEquals(1L, dto.getId());
        assertEquals(usuario, dto.getUsuario());
        assertEquals("Personagem", dto.getPersonagem());
        assertEquals(classe, dto.getClasse());
        assertEquals(raca, dto.getRaca());
        assertEquals(origem, dto.getOrigem());
        assertEquals(antecedente, dto.getAntecedente());
        assertEquals(notas, dto.getNotas());
        assertArrayEquals(imagem, dto.getImagem());
    }

    @Test
    void testBuilder() {
        UsuarioDTO usuario = new UsuarioDTO();
        ClasseDTO classe = new ClasseDTO();
        RacaDTO raca = new RacaDTO();
        OrigemDTO origem = new OrigemDTO();
        AntecedenteDTO antecedente = new AntecedenteDTO();
        NotasDTO notas = new NotasDTO();
        byte[] imagem = new byte[]{1, 2, 3};

        FichaDTO dto = FichaDTO.builder()
                .id(1L)
                .usuario(usuario)
                .personagem("Personagem")
                .classe(classe)
                .raca(raca)
                .origem(origem)
                .antecedente(antecedente)
                .notas(notas)
                .imagem(imagem)
                .build();

        assertEquals(1L, dto.getId());
        assertEquals(usuario, dto.getUsuario());
        assertEquals("Personagem", dto.getPersonagem());
        assertEquals(classe, dto.getClasse());
        assertEquals(raca, dto.getRaca());
        assertEquals(origem, dto.getOrigem());
        assertEquals(antecedente, dto.getAntecedente());
        assertEquals(notas, dto.getNotas());
        assertArrayEquals(imagem, dto.getImagem());
    }

    @Test
    void testNoArgsConstructor() {
        FichaDTO dto = new FichaDTO();
        assertNotNull(dto);
    }

    @Test
    void testAllArgsConstructor() {
        UsuarioDTO usuario = new UsuarioDTO();
        ClasseDTO classe = new ClasseDTO();
        RacaDTO raca = new RacaDTO();
        OrigemDTO origem = new OrigemDTO();
        AntecedenteDTO antecedente = new AntecedenteDTO();
        NotasDTO notas = new NotasDTO();
        byte[] imagem = new byte[]{1, 2, 3};

        FichaDTO dto = new FichaDTO(1L, usuario, "Personagem", classe, raca, origem, antecedente, notas, imagem);

        assertEquals(1L, dto.getId());
        assertEquals(usuario, dto.getUsuario());
        assertEquals("Personagem", dto.getPersonagem());
        assertEquals(classe, dto.getClasse());
        assertEquals(raca, dto.getRaca());
        assertEquals(origem, dto.getOrigem());
        assertEquals(antecedente, dto.getAntecedente());
        assertEquals(notas, dto.getNotas());
        assertArrayEquals(imagem, dto.getImagem());
    }
}