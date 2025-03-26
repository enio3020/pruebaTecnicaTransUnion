package com.api.pokemon.exception;

public class BadRequestException extends RuntimeException {

    private static final String DESCRIPTION = "Error: ";

    public BadRequestException(String detalle) {
        super(DESCRIPTION + ". " + detalle);
    }
}
