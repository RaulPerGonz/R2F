package com.example.rpg0810.api.restcontrollers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class ExceptionBody {
private LocalDateTime timestamp;
private HttpStatus status;
private String message;
private String path;
}