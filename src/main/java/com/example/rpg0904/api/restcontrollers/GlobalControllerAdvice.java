package com.example.rpg0904.api.restcontrollers;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.rpg0904.api.exceptions.CategoriaNotFoundException;
import com.example.rpg0904.api.exceptions.RutinaNotFoundException;
import com.example.rpg0904.api.exceptions.UsuarioNotFoundException;
import com.example.rpg0904.api.exceptions.ValoracionNotFoundException;

@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(RutinaNotFoundException.class)
    protected ResponseEntity<Object> handleRutinaNotFound(RutinaNotFoundException ex, WebRequest request) {
        ExceptionBody myBody = new ExceptionBody(LocalDateTime.now(),
                HttpStatus.NOT_FOUND, ex.getMessage(),
                ((ServletWebRequest) request).getRequest().getRequestURI().toString());
        return handleExceptionInternal(ex, myBody, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(CategoriaNotFoundException.class)
    protected ResponseEntity<Object> handleCategoriaNotFound(CategoriaNotFoundException ex, WebRequest request) {
        ExceptionBody myBody = new ExceptionBody(LocalDateTime.now(),
                HttpStatus.NOT_FOUND, ex.getMessage(),
                ((ServletWebRequest) request).getRequest().getRequestURI().toString());
        return handleExceptionInternal(ex, myBody, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(ValoracionNotFoundException.class)
    protected ResponseEntity<Object> handleValoracionNotFound(ValoracionNotFoundException ex, WebRequest request) {
        ExceptionBody myBody = new ExceptionBody(LocalDateTime.now(),
                HttpStatus.NOT_FOUND, ex.getMessage(),
                ((ServletWebRequest) request).getRequest().getRequestURI().toString());
        return handleExceptionInternal(ex, myBody, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    protected ResponseEntity<Object> handleUserNotFound(UsuarioNotFoundException ex, WebRequest request) {
        ExceptionBody myBody = new ExceptionBody(LocalDateTime.now(),
                HttpStatus.NOT_FOUND, ex.getMessage(),
                ((ServletWebRequest) request).getRequest().getRequestURI().toString());
        return handleExceptionInternal(ex, myBody, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
                ExceptionBody myBody = new ExceptionBody(LocalDateTime.now(),
                HttpStatus.NOT_FOUND, ex.getMessage(),
                ((ServletWebRequest) request).getRequest().getRequestURI().toString());
        return ResponseEntity.status(status).headers(headers).body(myBody);
    }
}
