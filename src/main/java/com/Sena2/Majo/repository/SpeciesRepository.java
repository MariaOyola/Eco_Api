package com.Sena2.Majo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Sena2.Majo.model.Species;

public interface SpeciesRepository  extends JpaRepository<Species, Integer>   {

@Query("SELECT s FROM Species s WHERE s.name LIKE %?1%")
public List<Species> findByName(String name);

//seleccionar por id no lo dejo por que de todas formas JPA ya lo reconoce por que la
   // clase Species  hereda el id  de la clase padre BaseModel


}

