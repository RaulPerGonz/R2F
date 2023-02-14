package com.example.rpg0810.controllers;

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

import com.example.rpg0810.domain.Categoria;
import com.example.rpg0810.domain.Rutina;
import com.example.rpg0810.services.CategoriaService;




@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    public CategoriaService categoriaService;

    @GetMapping("")
    public String mostrarProductos(Model model) {
        model.addAttribute("listaCat", categoriaService.findAll());

        return "categoriaViews/categoriasView";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("categoriaForm", new Categoria());
        return "categoriaViews/newCategoriaFormView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid @ModelAttribute("categoriaForm") Categoria nuevaCategoria,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "categoriaViews/newCategoriaFormView";
            categoriaService.add(nuevaCategoria);
        return "redirect:/categoria";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Categoria categoria = categoriaService.findById(id);
        // el commandobject del formulario es el empleado con el id solicitado
        if (categoria != null) {
            model.addAttribute("categoriaForm", categoria);
            return "categoriaViews/editarCategoriaView";
        }
        // si no lo encuentra vuelve a la página de inicio.
        return "redirect:/categoria";
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(
            @Valid @ModelAttribute("categoriaForm") Categoria categoria,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "categoriaViews/editarCategoriaView";
        } else {
            categoriaService.edit(categoria);
            return "redirect:/categoria";
        }
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        categoriaService.delete(categoriaService.findById(id));
        return "redirect:/categoria";
    }


    @GetMapping("/{id}")
    public String showCategoria(@PathVariable long id, Model model) {
        Categoria categoria = categoriaService.findById(id);
        List<Rutina> rutinas = categoriaService.obtenerRutinasPorCategoria(id);
        model.addAttribute("categoria", categoria);
        model.addAttribute("rutinas", rutinas);
        return "categoriaViews/categoriasView";
    }
}
