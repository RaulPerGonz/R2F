package com.example.rpg0810.api.restcontrollers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ApiError {
    private HttpStatus estado;
    private LocalDateTime fecha = LocalDateTime.now();
    private String mensaje;
}
