package com.example.rpg0810.services.RutinaValoracionService;

import java.util.List;

import com.example.rpg0810.domain.RutinaValoracion;

public interface RutinaValoracionService {
    List<RutinaValoracion> findAll();
    RutinaValoracion findById(long id);
    RutinaValoracion add(RutinaValoracion rutinaValoracion);
    List<RutinaValoracion> findAllByRutinaId(long rutinaId);
    List<RutinaValoracion> findAllByUsuarioId(long usuarioId);
}
