package com.example.rpg0904.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rpg0904.domain.Valoracion;
import com.example.rpg0904.services.ValoriacionService.ValoracionService;

@Controller
@RequestMapping("/valoracionO")
public class ValoracionController {
    @Autowired
    ValoracionService valoracionService;

    @GetMapping("")
    public String mostrarProductos(Model model) {

        List<Valoracion> valoraciones = valoracionService.findAll();
        model.addAttribute("valoraciones", valoraciones);
        return "usuario/valoracionesView";

    }

    // @GetMapping("/producto/{idProd}")
    // public String showValoracionesByProduct(@PathVariable long idProd, Model model) {
    //     List<Valoracion> valoraciones = valoracionService.findAllByProducto(idProd);
    //     model.addAttribute("valoraciones", valoraciones);
    //     return "valoracionViews/valoracionesView";
    // }

    // @GetMapping("/usuario/{idUser}")
    // public String showValoracionesByUser(@PathVariable long idUser, Model model) {
    //     List<Valoracion> valoraciones = valoracionService.findAllByUsuario(idUser);
    //     model.addAttribute("valoraciones", valoraciones);
    //     return "valoracionViews/valoracionesView";
    // }
}
