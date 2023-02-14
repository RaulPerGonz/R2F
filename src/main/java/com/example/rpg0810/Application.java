package com.example.rpg0810;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.rpg0810.domain.Categoria;
import com.example.rpg0810.domain.Rutina;
import com.example.rpg0810.domain.RutinaValoracion;
import com.example.rpg0810.domain.Usuario;
import com.example.rpg0810.domain.Valoracion;
import com.example.rpg0810.services.CategoriaService;
import com.example.rpg0810.services.RutinaService.RutinaService;
import com.example.rpg0810.services.RutinaValoracionService.RutinaValoracionService;
import com.example.rpg0810.services.UsuarioService.UsuarioService;
import com.example.rpg0810.services.ValoriacionService.ValoracionService;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CategoriaService categoriaService, RutinaService rutinaService,
            UsuarioService usuarioService, ValoracionService valoracionService,
            RutinaValoracionService rutinaValoracionService) {
        return args -> {

            categoriaService.add(new Categoria((long) 1, "Fuerza"));
            categoriaService.add(new Categoria((long) 2, "Cardio"));

            usuarioService.add(new Usuario("Raul", LocalDate.now()));
            usuarioService.add(new Usuario("Pedro", LocalDate.now()));

            rutinaService.add(new Rutina("PEAK PERFORMANCE", categoriaService.findById(1)));
            rutinaService.add(new Rutina("ARNOLD SPLIT", categoriaService.findById(1)));
            rutinaService.add(new Rutina("REACH THE TOP", categoriaService.findById(2)));

            rutinaValoracionService.add(new RutinaValoracion(rutinaService.findByNombre("ARNOLD SPLIT"),
                    valoracionService.add(new Valoracion(7L, "Buena rutina :)")), usuarioService.findByNombre("Raul")));

        };
    }
}
