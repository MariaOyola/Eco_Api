package com.Sena2.Majo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "behavior")
public class Behavior extends BaseModel {


    @Column(length = 50)
    private String type;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "behavior")
    private List<Animal> animals;

}
