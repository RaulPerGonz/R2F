package com.example.rpg0904.services;

import java.util.List;

import com.example.rpg0904.domain.Categoria;
import com.example.rpg0904.domain.Rutina;



public interface CategoriaService {
    Categoria add(Categoria cat);
    List<Categoria> findAll();
    Categoria findById(long id);
    Categoria edit(Categoria cat);
    void delete(Categoria cat);
    List<Rutina> obtenerRutinasPorCategoria(Long id);
}
