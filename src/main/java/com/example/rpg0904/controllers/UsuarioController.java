package com.example.rpg0904.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rpg0904.domain.Usuario;
import com.example.rpg0904.services.UsuarioService.UsuarioService;

@Controller
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/gestion/usuarios")
    public String mostrarProductos(Model model) {

        List<Usuario> usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "adminViews/gestionUsuarioView";

    }

}
