package com.example.rpg0904.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rpg0904.domain.Categoria;

public interface CategoriaRepository extends JpaRepository 
<Categoria, Long>{
    Categoria findByNombre(String nombre);
}
