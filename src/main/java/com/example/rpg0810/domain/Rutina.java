package com.example.rpg0810.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Rutina {

    @ApiModelProperty(value = "ID de rutina", dataType = "long", example = "1", position = 1)
    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(value = "Nombre rutina", dataType = "String", example = "Rutina de hipertrofia", position = 2)
    private String nombre;

    @ApiModelProperty(value = "Descripción de la rutina", dataType = "String", example = "Esta rutina es perfecta para aumentar masa muscular", position = 3)
    private String descripcion;

    @ApiModelProperty(value = "Objetivos de la rutina", dataType = "List<String>", example = "[\"Aumento de masa muscular\", \"Perdida de peso\"]", position = 4)
    @ElementCollection
    private List<String> objetivos;

    @ApiModelProperty(value = "Precio de la rutina", dataType = "double", example = "29.99", position = 5)
    private double precio;

    @ApiModelProperty(value = "Tipo de acceso a la rutina", dataType = "String", example = "Gratis", position = 6)
    private String acceso;

    @ManyToOne
    @JoinColumn(name = "CATEGO_ID", foreignKey = @ForeignKey(name = "CATEGO_ID_FK"))
    private Categoria categoria;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "rutina", cascade = CascadeType.REMOVE)
    private List<RutinaValoracion> rutinaValoraciones = new ArrayList<>();

    public Rutina(String nombre, Categoria categoria, String descripcion, List<String> objetivos, double precio, String acceso) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.objetivos = objetivos;
        this.precio = precio;
        this.acceso = acceso;
    }

    public Rutina orElseThrow(Object object) {
        return null;
    }
}
