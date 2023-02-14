package com.example.rpg0810.services.RutinaService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.rpg0810.api.exceptions.RutinaNotFoundException;
import com.example.rpg0810.domain.Rutina;
import com.example.rpg0810.repositories.RutinaRepository;

@Service
@Primary
public class RutinaServiceImpl implements RutinaService {

    @Autowired
    RutinaRepository repositorio;

    public List<Rutina> findAll() {
        return repositorio.findAll();
    }

    public Rutina add(Rutina rutina) {
        return repositorio.save(rutina);
    }

    public void delete(Long id) {
        repositorio.deleteById(id);
    }

    private final Integer pageSize = 10;
    private final String sorting = "nombre";

    public List<Rutina> findRutinaByPage(int pageNum) {
        Pageable paging = PageRequest.of(pageNum, pageSize, Sort.by(sorting).ascending());
        Page<Rutina> pagedResult = repositorio.findAll(paging);

        if (pagedResult.hasContent())
            return pagedResult.getContent();
        else
            return null;
    }

    public int getTotalPaginas() {
        Pageable paging = PageRequest.of(0, pageSize, Sort.by(sorting).ascending());
        Page<Rutina> pagedResult = repositorio.findAll(paging);
        return pagedResult.getTotalPages();
    }

    public Rutina findById(long id) {
        return repositorio.findById(id).orElseThrow(() -> new RutinaNotFoundException(id));
    }

    public Rutina findByNombre(String nombre) {
        return repositorio.findByNombre(nombre).orElseThrow(null);
    }

    public Rutina edit(Rutina rutina) {
        return repositorio.save(rutina);
    }

}
