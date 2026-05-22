package com.Sena2.Majo.model;
import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass // esta es una superclase en el cual no sera parte de una entidad en la base de datos, osea es donde otras clases que si son entidades de la base de datos 
// heredaran atributos de esta clase


/// esta es la clase abstarcta
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    private LocalDateTime created = LocalDateTime.now(); // LocalDateTime.now(); ( sirve para generar la fecha y hora actual en el cual se se crea el objeto)
    private LocalDateTime update = LocalDateTime.now();  // este tanbien sirve para lo mismo pero es para ver las  actualizaciones en la fecha y hora actual

    @PreUpdate  

    public void preUpdate() {    /// este metodo nos sirve para registrar las actualizaciones
        update = LocalDateTime.now();  
    }  
    @PrePersist
    public void  prePersist() {   /// este metodo nos sirve para registrar creaciones 
        created = LocalDateTime.now(); 
        update = LocalDateTime.now();   // tambien se pueden registrar las actualizaciones
    
    }
}
    

    
