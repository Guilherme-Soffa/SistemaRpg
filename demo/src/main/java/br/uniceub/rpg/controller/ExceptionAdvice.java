package br.uniceub.rpg.controller;

import br.uniceub.rpg.exception.RpgException;
import br.uniceub.rpg.service.dto.ApiErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(RpgException.class)
    public ResponseEntity<ApiErrorDTO> handleException(RpgException exception) {
        final var dto = new ApiErrorDTO();
        dto.setMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(dto);
    }
}