package com.example.rpg0904.domain;

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
public class Valoracion {
    @Id
    @GeneratedValue
    private Long id;

    private Long puntuacion;

    private String comentarios;


    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "valoracion", cascade = CascadeType.REMOVE)
    private List<RutinaValoracion> rutinaValoraciones= new ArrayList<>();

    public Valoracion(Long puntuacion, String comentarios) {
        this.puntuacion = puntuacion;
        this.comentarios = comentarios;
    }


    

}
