package com.Sena2.Majo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Sena2.Majo.model.Animal;


public interface AnimalRepository extends JpaRepository<Animal, Integer>{

    @Query(
        "SELECT A " +
        "FROM Animal A " +
        "WHERE A.name LIKE %?1%"
    )
 List<Animal> findByName(String name);

   //seleccionar por id no lo dejo por que de todas formas JPA ya lo reconoce por que la
   // clase Animal hereda el id  de la clase padre BaseModel

    // vamos a  implementar la pivote de habitad

    @Query(
        value = "SELECT a.* " +
                "FROM animal a " +
                "INNER JOIN animal_habitat ah ON a.id = ah.id_animal " +
                "WHERE ah.id_habitat = ?1",
        nativeQuery = true
    )
    public List<Animal> findByHabitatId(Integer habitatId);
}
