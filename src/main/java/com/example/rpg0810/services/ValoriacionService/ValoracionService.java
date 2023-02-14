package com.example.rpg0810.services.ValoriacionService;

import java.util.List;

import com.example.rpg0810.domain.Valoracion;




public interface ValoracionService {
   
    Valoracion add(Valoracion Valoracion);
    List<Valoracion> findAll();
    Valoracion findById(long id);
    void delete(Valoracion Valoracion);
    Valoracion edit(Valoracion valoracion);
    
    
   } 