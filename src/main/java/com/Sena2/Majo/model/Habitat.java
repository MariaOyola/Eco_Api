package com.Sena2.Majo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
@Table(name = "habitat")
public class Habitat  extends BaseModel{
    @Column(length = 50)
    private String type;

    @Column(length = 50)
    private String climate;

    @Column(length = 50)
    private String location;

  @ManyToMany(mappedBy = "habitats")
    private List<Animal> animals;
    
}
