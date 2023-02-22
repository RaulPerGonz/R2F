package com.example.rpg0904.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id") 
@Entity
public class RutinaValoracion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rutina_id")
    private Rutina rutina;

    @ManyToOne
    @JoinColumn(name = "valoracion_id")
    private Valoracion valoracion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public RutinaValoracion(Rutina rutina, Valoracion valoracion, Usuario usuario) {
        this.rutina = rutina;
        this.valoracion = valoracion;
        this.usuario = usuario;
    }

    
  
}