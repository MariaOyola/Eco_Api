package com.Sena2.Majo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.Sena2.Majo.model.ClassEntity;

public interface ClassEntityRepository extends JpaRepository<ClassEntity, Integer> {

    @Query("SELECT C FROM ClassEntity C WHERE C.name LIKE %?1%")
    public List<ClassEntity> findByName(String name);

    //seleccionar por id no lo dejo por que de todas formas JPA ya lo reconoce por que la
   // clase ClassEntity hereda el id  de la clase padre BaseModel


}
