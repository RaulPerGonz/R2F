package com.example.rpg0904.services.RutinaService;

import java.util.List;

import com.example.rpg0904.domain.Rutina;

public interface RutinaService {

    List<Rutina> findAll();

    Rutina add(Rutina rutina);

    Rutina findById(long id);

    List<Rutina> findRutinaByPage(int numPagina);

    int getTotalPaginas();

    void delete(Long id);

    Rutina findByNombre(String nombre);

    Rutina edit(Rutina rutina);

}