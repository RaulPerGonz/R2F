package com.example.rpg0904.api.exceptions;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(Long id) {
        super("No se puede encontrar el suaurio con id: " + id);
    }
}
