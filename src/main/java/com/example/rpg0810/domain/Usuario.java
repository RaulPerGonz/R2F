package com.example.rpg0810.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private LocalDate fechaRegistro;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    private List<RutinaValoracion> rutinaValoraciones= new ArrayList<>();

    public Usuario(String nombre, LocalDate fechaRegistro) {
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
    }

}
