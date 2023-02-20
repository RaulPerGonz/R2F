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
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rpg0810.domain.Rutina;
import com.example.rpg0810.services.CategoriaServiceImplBD;
import com.example.rpg0810.services.RutinaService.RutinaServiceImpl;



@Controller

public class RutinaController {

    @Autowired
    public RutinaServiceImpl rutinaService;
    @Autowired
    public CategoriaServiceImplBD categoriaService;

    @GetMapping("/rutinas")
    public String mostrarProductos(Model model) {
        return "redirect:/rutinas/pagina/0";

    }


    @GetMapping("/rutinas/pagina/{id}")
    public String showPage(@PathVariable Integer id, Model model) {
        int ultPag = rutinaService.getTotalPaginas() - 1;
        if (id < 0 || id > ultPag)
            return "redirect:/rutinas/pagina/0"; // control de errores
        Integer pagSig = ultPag > id ? id + 1 : ultPag;
        Integer pagAnt = id > 0 ? id - 1 : 0;
        model.addAttribute("listaRutinas", rutinaService.findRutinaByPage(id));
        model.addAttribute("paginaSiguiente", pagSig);
        model.addAttribute("paginaAnterior", pagAnt);
        return "rutinas/rutinasView";
    }

    @GetMapping("/gestion/rutinas")
    public String mostrarRutinas( Model model) {
        
        model.addAttribute("listaRutinas", rutinaService.findAll());
        return "adminViews/gestionRutinasView";
    }

    @GetMapping("/rutina/{id}")
    public String showRutina(@PathVariable Integer id,Model model) {
        model.addAttribute("rutina", rutinaService.findById(id));
      
        return "rutinas/rutinaView";
    }



    @GetMapping("/rutina/new")
    public String showNew(Model model) {
        model.addAttribute("rutinaForm", new Rutina());
        model.addAttribute("listaCategorias", categoriaService.findAll());
        return "adminViews/newRutinaView";
    }

    @PostMapping("/rutina/new/submit")
    public String showNewSubmit(
            @Valid @ModelAttribute("rutinaForm") Rutina nuevaRutina,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "rutinas/newRutinaFormView";
        rutinaService.add(nuevaRutina);
        return "redirect:/rutinas/pagina/0";
    }

    @GetMapping("/rutina/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Rutina rutina = rutinaService.findById(id);
        // el commandobject del formulario es el empleado con el id solicitado
        if (rutina != null) {
            model.addAttribute("rutinaForm", rutina);
            model.addAttribute("listaCategorias", categoriaService.findAll());
            return "adminViews/editarRutinaView";
        }
        // si no lo encuentra vuelve a la página de inicio.
        return "redirect:/";
    }

    @PostMapping("/rutina/edit/submit")
    public String showEditSubmit(
            @Valid @ModelAttribute("rutinaForm") Rutina rutina,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "adminViews/editarRutinaView";
        } else {
           // rutinaService.edit(rutina);
            return "redirect:/rutinas";
        }
    }

    @GetMapping("/rutina/delete/{id}")
    public String showDelete(@PathVariable long id) {
       // rutinaService.delete(id);
        return "redirect:/productos";
    }
}
