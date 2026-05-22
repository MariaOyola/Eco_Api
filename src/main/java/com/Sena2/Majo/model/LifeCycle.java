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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "life_cycle")
public class LifeCycle extends BaseModel {

    @Column(length = 50)
    private String stage;

  @Column (length = 50)
    private String duration;

        @OneToMany(mappedBy = "lifeCycle")
    private List<Animal> animals;

}
