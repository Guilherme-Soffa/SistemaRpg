package br.uniceub.rpg.exception;


public class RpgException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RpgException() {
    }

    public RpgException(String message) {
        super(message);
    }

    public RpgException(String message, Throwable cause) {
        super(message, cause);
    }
}
