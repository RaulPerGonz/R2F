package com.example.rpg0904.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rpg0904.domain.Usuario;
import com.example.rpg0904.services.UsuarioService.UserDetailsServiceImpl;
import com.example.rpg0904.services.UsuarioService.UsuarioService;

@Controller
@RequestMapping("/gestion/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UserDetailsServiceImpl userdetails;

    @GetMapping("")
    public String mostrarProductos(Model model) {

        List<Usuario> usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "adminViews/gestionUsuarioView";

    }

    @PostMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            model.addAttribute("usuarioForm", usuario);

            return "adminViews/editarUsuarioView";
        }
        return "redirect:/gestion/usuarios";
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(
            @Valid @ModelAttribute("usuarioForm") Usuario usuario,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "adminViews/editUsuarioView";
        } else {

            usuarioService.edit(usuario);
            return "redirect:/gestion/usuarios";
        }
    }

}
