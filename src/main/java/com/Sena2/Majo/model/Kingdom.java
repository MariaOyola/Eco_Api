package com.Sena2.Majo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kingdom")
public class Kingdom  extends BaseModel{

    @Column(length = 50)
    private String name;

    @OneToMany(mappedBy = "kingdom")
    private List<ClassEntity> classes;

}

    

