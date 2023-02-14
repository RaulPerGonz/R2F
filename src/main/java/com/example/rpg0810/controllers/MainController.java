package com.example.rpg0810.controllers;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.rpg0810.services.ContactaFormInfo;



@Controller
public class MainController {

   

    @GetMapping({ "/", "/index", "/home" })
    public String mostrarRaiz(@RequestParam (name="usuario") Optional <String> usuario,Model model ) {
        model.addAttribute("fecha", LocalDate.now().toString());
        model.addAttribute("usuario",usuario.orElse(" "));
        return "indexView";
    }

    @GetMapping("/quienesSomos")
    public String mostrarQuienesSomos() {
        return "quienesSomosView";
    }

    @GetMapping("/contacta")
    public String mostrarContacta(Model model) {
        model.addAttribute("contactaFormInfo", new ContactaFormInfo());
        return "contactaView";
    }

    @PostMapping("/contacta/submit")
    public String mostrarContactaSubmit(@ModelAttribute ContactaFormInfo contactaFormInfo,Model model) {
        return "contactaSubmitView";
    }

    
    
}
