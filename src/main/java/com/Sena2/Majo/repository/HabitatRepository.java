package com.Sena2.Majo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Sena2.Majo.model.Habitat;

public interface HabitatRepository extends JpaRepository<Habitat, Integer>{

    // Buscar habitats por nombre
    @Query("SELECT H FROM Habitat H WHERE H.type LIKE %?1%")
public List<Habitat> findByType(String type);

  @Query("SELECT H FROM Habitat H WHERE H.location LIKE %?1%")
public List<Habitat>findByLocation(String location);

  @Query("SELECT H FROM Habitat H WHERE H.climate LIKE %?1%")
public List<Habitat>findByClimate(String climate);

// Implementar consultas ( si es nesesaria)  

//seleccionar por id no lo dejo por que de todas formas JPA ya lo reconoce por que la
   // clase Habitat hereda el id  de la clase padre BaseModel

}
