package com.Sena2.Majo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Sena2.Majo.model.LifeCycle;





public interface LifeCycleRepository extends JpaRepository <LifeCycle, Integer> {

//seleccionar por id no lo dejo por que de todas formas JPA ya lo reconoce por que la
   // clase LifeCycle  hereda el id  de la clase padre BaseModel


@Query ("SELECT L FROM LifeCycle L WHERE L.stage LIKE %?1%")
public List<LifeCycle> filterByStage(String stage); 

@Query ("SELECT L FROM LifeCycle L WHERE L.duration LIKE %?1%")
public List<LifeCycle>  findByDuration(String duration);

}
