package com.Sena2.Majo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Sena2.Majo.model.Behavior;

public interface BehaviorRepository extends JpaRepository<Behavior, Integer>{

    @Query(
        "SELECT B " +
        "FROM Behavior B " +
        "WHERE B.type LIKE %?1%"
    )
    public List<Behavior>  findByType(String type);

    //seleccionar por id no lo dejo por que de todas formas JPA ya lo reconoce por que la
   // clase Behavior hereda el id  de la clase padre BaseModel

}

