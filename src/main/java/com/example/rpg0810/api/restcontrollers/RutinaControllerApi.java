package com.example.rpg0810.api.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rpg0810.domain.Rutina;
import com.example.rpg0810.services.RutinaService.RutinaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
public class RutinaControllerApi {

    @Autowired
    private RutinaService rutinaService;

    @GetMapping("/rutinas")
    public List<Rutina> getList() {
        return rutinaService.findAll();

    }

    @ApiOperation(value = "Obtener un producto por su ID", notes = "Descripción más detallada ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Rutina.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class) 
        })



    @GetMapping("/rutinas/{id}")
    public Rutina getRutina(@ApiParam(value="ID del producto", required=true, type = "long")@PathVariable Long id) {
        return  rutinaService.findById(id);
    }

    @PostMapping("/rutina")
    public ResponseEntity<?> newElement(@Valid @RequestBody Rutina nuevoRutina) {
        Rutina rutina = rutinaService.add(nuevoRutina);
        return ResponseEntity.status(HttpStatus.CREATED).body(rutina); // cod 201
    }

    @PutMapping("/rutina/{id}")
    public Rutina editElement(@Valid @RequestBody Rutina editRutina,
            @PathVariable Long id) {
        rutinaService.findById(id); // ejecutamos esto para ver si se produce excepción
        return rutinaService.edit(editRutina);
    }

    @DeleteMapping("rutina/{id}")
    public ResponseEntity<?> deleteElement(@PathVariable Long id) {
        rutinaService.findById(id);
        rutinaService.delete(id);
        return ResponseEntity.noContent().build(); // cod 204
    }
}