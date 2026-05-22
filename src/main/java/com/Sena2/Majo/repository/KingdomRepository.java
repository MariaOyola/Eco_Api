package com.Sena2.Majo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.Sena2.Majo.model.Kingdom;
import java.util.List;



public interface KingdomRepository  extends JpaRepository <Kingdom, Integer>{ 


@Query("SELECT K FROM Kingdom K WHERE K.name LIKE %?1%")
public List<Kingdom> filterByName(String name);



//seleccionar por id no lo dejo por que de todas formas JPA ya lo reconoce por que la
   // clase Kingdom  hereda el id  de la clase padre BaseModel

   }
