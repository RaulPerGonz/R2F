package com.example.rpg0810.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rpg0810.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombre(String nombre);
}
