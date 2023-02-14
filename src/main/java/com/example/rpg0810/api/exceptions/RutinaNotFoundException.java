package com.example.rpg0810.api.exceptions;

public class RutinaNotFoundException extends RuntimeException {
    public RutinaNotFoundException(Long id) {
        super("No se puede encontrar la rutina con id: " + id);
    }
}
