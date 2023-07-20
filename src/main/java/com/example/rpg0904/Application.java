package com.example.rpg0904;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.rpg0904.domain.Categoria;
import com.example.rpg0904.domain.Rol;
import com.example.rpg0904.domain.Rutina;
import com.example.rpg0904.domain.RutinaValoracion;
import com.example.rpg0904.domain.Usuario;
import com.example.rpg0904.domain.Valoracion;
import com.example.rpg0904.services.CategoriaService;
import com.example.rpg0904.services.RutinaService.RutinaService;
import com.example.rpg0904.services.RutinaValoracionService.RutinaValoracionService;
import com.example.rpg0904.services.UsuarioService.UserDetailsServiceImpl;
import com.example.rpg0904.services.UsuarioService.UsuarioService;
import com.example.rpg0904.services.ValoriacionService.ValoracionService;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CategoriaService categoriaService, RutinaService rutinaService,
            UsuarioService usuarioService,UserDetailsServiceImpl userDetailsServiceImpl, ValoracionService valoracionService,
            RutinaValoracionService rutinaValoracionService) {
        return args -> {
                userDetailsServiceImpl.add(new Usuario("admin", "1234", Rol.ADMIN));
            categoriaService.add(new Categoria((long) 1, "Fuerza"));
            categoriaService.add(new Categoria((long) 2, "Cardio"));

           

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
                    valoracionService.add(new Valoracion( "Buena rutina :)")), usuarioService.findByNombre("Raul")));

        };
    }
}
