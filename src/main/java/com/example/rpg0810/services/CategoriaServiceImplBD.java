package com.example.rpg0810.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rpg0810.api.exceptions.CategoriaNotFoundException;
import com.example.rpg0810.domain.Categoria;
import com.example.rpg0810.domain.Rutina;
import com.example.rpg0810.repositories.CategoriaRepository;
import com.example.rpg0810.repositories.RutinaRepository;

@Service
public class CategoriaServiceImplBD implements CategoriaService {
    @Autowired
    CategoriaRepository repositorio;

    @Autowired
    RutinaRepository rutinaRepository;

    public Categoria add(Categoria categoria) {
        return repositorio.save(categoria);

    }

    public List<Categoria> findAll() {
        return repositorio.findAll();
    }

    public Categoria findById(long id) {
        return repositorio.findById(id).orElseThrow(() -> new CategoriaNotFoundException(id));
    
    }

    public Categoria edit(Categoria categoria) {
        return repositorio.save(categoria);
    }

    public void delete(Categoria categoria) {
        repositorio.delete(categoria); // también es cómodo deleteById(id)
    }

    public Categoria findByNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }

    public List<Rutina> obtenerRutinasPorCategoria(Long idCategoria) {
        Categoria categoria = repositorio.findById(idCategoria).get();
        return rutinaRepository.findByCategoria(categoria);
      }

   
}
