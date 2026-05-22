package com.Sena2.Majo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import jakarta.persistence.Column;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "class_entity")

public class ClassEntity extends BaseModel {
    @Column(length = 50)
    private String name;

    
    @ManyToOne
    @JoinColumn(name = "id_kingdom")
    private Kingdom kingdom;

    @OneToMany(mappedBy = "classEntity")
    private List<Species> species;
}
