package br.uniceub.rpg.service.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiErrorDTOTest {

    @Test
    void testGettersAndSetters() {
        ApiErrorDTO dto = new ApiErrorDTO();
        dto.setMessage("Error message");

        assertEquals("Error message", dto.getMessage());
    }
}