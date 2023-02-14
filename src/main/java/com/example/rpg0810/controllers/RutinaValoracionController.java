package com.example.rpg0810.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.rpg0810.domain.RutinaValoracion;
import com.example.rpg0810.services.RutinaService.RutinaService;
import com.example.rpg0810.services.RutinaValoracionService.RutinaValoracionService;
import com.example.rpg0810.services.UsuarioService.UsuarioService;
import com.example.rpg0810.services.ValoriacionService.ValoracionService;

@Controller
public class RutinaValoracionController {

    @Autowired
    RutinaValoracionService rutinaValoracionService;

    @Autowired
    RutinaService rutinaService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ValoracionService valoracionService;

    @GetMapping("/valoraciones/usuario/{idUsuario}")
    public String mostrarValoracionesDeUsuario(@PathVariable long idUsuario, Model model) {
        model.addAttribute("listaUsuarioValoracion", rutinaValoracionService.findAllByUsuarioId(idUsuario));
        return "usuario/valoracionesUsuarioView";
    }

    @GetMapping("/valoraciones/rutina/{idRutina}")
    public String mostrarValoracionesDeRutina(@PathVariable long idRutina, Model model) {
        model.addAttribute("listaRutinaValoracion", rutinaValoracionService.findAllByRutinaId(idRutina));
        return "rutinas/valoracionesRutinaView";
    }
}
