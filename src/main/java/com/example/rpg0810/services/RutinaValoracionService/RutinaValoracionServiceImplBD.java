package com.example.rpg0810.services.RutinaValoracionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rpg0810.domain.RutinaValoracion;
import com.example.rpg0810.repositories.RutinaValoracionRepository;

@Service
public class RutinaValoracionServiceImplBD implements RutinaValoracionService {

    @Autowired
    RutinaValoracionRepository repositorio;

    public List<RutinaValoracion> findAll() {
        return repositorio.findAll();
    }

    public RutinaValoracion add(RutinaValoracion rutinaValoracion) {
        return repositorio.save(rutinaValoracion);
    }

    public RutinaValoracion findById(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public List<RutinaValoracion> findAllByRutinaId(long rutinaId) {
        return repositorio.findAllByRutinaId(rutinaId);
    }

    public List<RutinaValoracion> findAllByUsuarioId(long usuarioId) {
        return repositorio.findAllByUsuarioId(usuarioId);
    }

}
