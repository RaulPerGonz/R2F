package com.example.rpg0904.services.UsuarioService;

import java.util.List;

import com.example.rpg0904.domain.Usuario;

public interface UsuarioService {
    Usuario add(Usuario usuario);
    List<Usuario> findAll();
    Usuario findById(long id);
    void delete(Usuario usuario);
    Usuario findByNombre(String nombre);
    Usuario edit(Usuario usuario) ;
}
