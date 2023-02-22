package com.example.rpg0904.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rpg0904.domain.Categoria;
import com.example.rpg0904.domain.Rutina;

public interface RutinaRepository extends JpaRepository 
<Rutina, Long>{
    Rutina findByNombre(String nombre);
    List<Rutina> findByCategoria(Categoria categoria);
}
