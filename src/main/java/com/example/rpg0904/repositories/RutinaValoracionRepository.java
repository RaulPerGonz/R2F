package com.example.rpg0904.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rpg0904.domain.RutinaValoracion;

public interface RutinaValoracionRepository  extends
JpaRepository<RutinaValoracion, Long>{
    List<RutinaValoracion> findAllByRutinaId(long rutinaId);
    List<RutinaValoracion> findAllByUsuarioId(long usuarioId);
    List<RutinaValoracion> findAllByValoracionId(long valoracionId);
}
