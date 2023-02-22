package com.example.rpg0904.api.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rpg0904.domain.Usuario;
import com.example.rpg0904.services.UsuarioService.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioControllerApi {

    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> getList() {
        List<Usuario> listaUsuarios = usuarioService.findAll();
        return listaUsuarios;
    }
    @GetMapping("/usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        return  usuarioService.findById(id);
    }
  
    @PostMapping("/usuario")
    public ResponseEntity<?> newElement(@Valid @RequestBody Usuario nuevoUsuario) {
        Usuario usuario = usuarioService.add(nuevoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario); // cod 201
    }

    @PutMapping("/usuario/{id}")
    public Usuario editElement(@Valid @RequestBody Usuario editUsuario,
            @PathVariable Long id) {
                usuarioService.findById(id); // ejecutamos esto para ver si se produce excepción
        return usuarioService.edit(editUsuario);
    }
}