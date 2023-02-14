package com.example.rpg0810.api.exceptions;

public class CategoriaNotFoundException extends RuntimeException {
    public CategoriaNotFoundException(Long id) {
        super("No se puede encontrar la categoria con id: " + id);
    }
}
