package com.example.rpg0810.api.exceptions;

public class AuthenticationError extends RuntimeException {
    public AuthenticationError() {
        super("Credenciales de autenticación inválidas.");
    }
}