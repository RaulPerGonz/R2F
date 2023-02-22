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
import com.example.rpg0904.services.CategoriaService;

@RestController
@RequestMapping("/api")
public class CategoriaControllerApi {
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping("/categorias")
    public List<Categoria> getList() {
        List<Categoria> listaCategorias = categoriaService.findAll();
        return listaCategorias;
    }
    @GetMapping("/categoria/{id}")
    public Categoria getCategoria(@PathVariable Long id) {
        return  categoriaService.findById(id);
    }
  
    @PostMapping("/categoria")
    public ResponseEntity<?> newElement(@Valid @RequestBody Categoria nuevoCategoria) {
        Categoria categoria = categoriaService.add(nuevoCategoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria); // cod 201
    }

    @PutMapping("/categoria/{id}")
    public Categoria editElement(@Valid @RequestBody Categoria editCategoria,
            @PathVariable Long id) {
                categoriaService.findById(id); // ejecutamos esto para ver si se produce excepción
        return categoriaService.edit(editCategoria);
    }
}
