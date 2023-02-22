package com.example.rpg0904.api.exceptions;

public class ValoracionNotFoundException extends RuntimeException {
    public ValoracionNotFoundException(Long id) {
        super("No se puede encontrar la valoracion con id: " + id);
    }
}
