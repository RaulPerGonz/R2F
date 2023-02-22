package com.example.rpg0904.services.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rpg0904.api.exceptions.RutinaNotFoundException;
import com.example.rpg0904.api.exceptions.UsuarioNotFoundException;
import com.example.rpg0904.domain.Usuario;
import com.example.rpg0904.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImplBD implements UsuarioService {
    @Autowired
    UsuarioRepository repositorio;



    public Usuario add(Usuario usuario) {
        return repositorio.save(usuario);

    }

    public Usuario findByNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }

    public List<Usuario> findAll() {
        return repositorio.findAll();
    }

    public Usuario findById(long id) {
        return repositorio.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));
    }


    public void delete(Usuario Usuario) {
        repositorio.delete(Usuario); // también es cómodo deleteById(id)
    }

    public Usuario edit(Usuario usuario) {
        return repositorio.save(usuario);
    }


   
}
