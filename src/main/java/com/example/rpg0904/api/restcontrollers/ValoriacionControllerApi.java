package com.example.rpg0904.api.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rpg0904.domain.Categoria;
import com.example.rpg0904.domain.Valoracion;
import com.example.rpg0904.services.ValoriacionService.ValoracionService;

@RestController
@RequestMapping("/api")
public class ValoriacionControllerApi {
    @Autowired
    private ValoracionService valoracionService;
    @GetMapping("/valoraciones")
    public List<Valoracion> getList() {
        List<Valoracion> listaValoraciones = valoracionService.findAll();
        return listaValoraciones;
    }
    @GetMapping("/valoracion/{id}")
    public Valoracion getValoracion(@PathVariable Long id) {
        return  valoracionService.findById(id);
    }
  
    @PostMapping("/valoracion")
    public ResponseEntity<?> newElement(@Valid @RequestBody Valoracion nuevValoracion) {
        Valoracion valoracion = valoracionService.add(nuevValoracion);
        return ResponseEntity.status(HttpStatus.CREATED).body(valoracion); // cod 201
    }

    @PutMapping("/valoracion/{id}")
    public Valoracion editElement(@Valid @RequestBody Valoracion editValoracion,
            @PathVariable Long id) {
                valoracionService.findById(id); // ejecutamos esto para ver si se produce excepción
        return valoracionService.edit(editValoracion);
    }
}
