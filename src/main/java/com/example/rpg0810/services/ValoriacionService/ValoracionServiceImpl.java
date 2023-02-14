package com.example.rpg0810.services.ValoriacionService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.rpg0810.api.exceptions.ValoracionNotFoundException;
import com.example.rpg0810.domain.Valoracion;
import com.example.rpg0810.repositories.ValoracionRepository;

@Service
@Primary
public class ValoracionServiceImpl implements ValoracionService {

    @Autowired
    ValoracionRepository repositorio;

    public Valoracion add(Valoracion Valoracion) {
        return repositorio.save(Valoracion);

    }

    public List<Valoracion> findAll() {
        return repositorio.findAll();
    }

    public Valoracion findById(long id) {
        return repositorio.findById(id).orElseThrow(() -> new ValoracionNotFoundException(id));
    }

    public void delete(Valoracion Valoracion) {
        repositorio.delete(Valoracion); // también es cómodo deleteById(id)
    }

  
    public Valoracion edit(Valoracion valoracion) {
        return repositorio.save(valoracion);
    }
  

}
