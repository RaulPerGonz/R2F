package com.example.rpg0810;

import java.time.LocalDate;
import java.util.Arrays;

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

            rutinaService.add(new Rutina("PEAK PERFORMANCE", categoriaService.findById(1),
                    "Rutina avanzada para mejorar el rendimiento físico",
                    Arrays.asList("Mejora de la resistencia", "Fortalecimiento muscular"), 49.99, "Premium"));
            rutinaService.add(
                    new Rutina("WEIGHT LOSS", categoriaService.findById(1), "Rutina para quemar grasa y bajar de peso",
                            Arrays.asList("Pérdida de peso", "Mejora de la condición física"), 19.99, "Premium"));
            rutinaService.add(
                    new Rutina("LEAN & STRONG", categoriaService.findById(2), "Rutina para tonificar y ganar fuerza",
                            Arrays.asList("Tonificación muscular", "Mejora de la fuerza"), 29.99, "Premium"));

            rutinaValoracionService.add(new RutinaValoracion(rutinaService.findByNombre("PEAK PERFORMANCE"),
                    valoracionService.add(new Valoracion(7L, "Buena rutina :)")), usuarioService.findByNombre("Raul")));

        };
    }
}
