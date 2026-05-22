package com.Sena2.Majo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "species")
public class Species extends BaseModel {

    @Column(length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_class")
    private ClassEntity classEntity;

    @OneToMany(mappedBy = "species")
    private List<Animal> animals;
}
