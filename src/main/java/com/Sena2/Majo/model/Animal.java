package com.Sena2.Majo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter  // esta funcion me implementa los get  (obtener)
@Setter     // esta funcion me implementa los set  ( modificar) 
@NoArgsConstructor // este es para contructores vacios
@AllArgsConstructor // Este para los contructores con parametros
@Table(name = "animal")
public class Animal extends BaseModel {


    @Column(length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_species")
    private Species species;

    @ManyToOne
    @JoinColumn(name = "id_cycle")
    private LifeCycle lifeCycle;

    @ManyToOne
    @JoinColumn(name = "id_behavior")
    private Behavior behavior;

    @ManyToMany
    @JoinTable(
            name = "animal_habitat",
            joinColumns = @JoinColumn(name = "id_animal"),
            inverseJoinColumns = @JoinColumn(name = "id_habitat")
    )
    private List<Habitat> habitats;

    @ManyToMany
    @JoinTable(
            name = "animal_food",
            joinColumns = @JoinColumn(name = "id_animal"),
            inverseJoinColumns = @JoinColumn(name = "id_food")
    )
    private List<Food> food;
}

