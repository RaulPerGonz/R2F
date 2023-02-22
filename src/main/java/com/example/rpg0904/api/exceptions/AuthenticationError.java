package com.example.rpg0904.api.exceptions;

public class AuthenticationError extends RuntimeException {
    public AuthenticationError() {
        super("Credenciales de autenticación inválidas.");
    }
}