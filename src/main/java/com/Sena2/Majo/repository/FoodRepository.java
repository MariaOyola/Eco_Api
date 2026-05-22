package com.Sena2.Majo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Sena2.Majo.model.Food;


public interface FoodRepository extends JpaRepository<Food,Integer> {

    @Query("SELECT F FROM Food F WHERE F.name LIKE %?1%")
    public List<Food> findByName(String name);

    @Query("SELECT F FROM Food F WHERE F.type LIKE %?1%")
    public List<Food> findByType(String type);

    //seleccionar por id no lo dejo por que de todas formas JPA ya lo reconoce por que la
   // clase Food  hereda el id  de la clase padre BaseModel

}


    