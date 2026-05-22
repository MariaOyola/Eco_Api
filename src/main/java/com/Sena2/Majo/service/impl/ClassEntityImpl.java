package com.Sena2.Majo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sena2.Majo.dto.ClassEntityDto;
import com.Sena2.Majo.dto.response.ClassEntityResponseDto;
import com.Sena2.Majo.model.ClassEntity;
import com.Sena2.Majo.repository.ClassEntityRepository;
import com.Sena2.Majo.service.Service.ClassEntityService;

@Service
public class ClassEntityImpl implements ClassEntityService {

    @Autowired  // este lo que hace es crear un tipo de objeto sin necesidad de intranciar con new
    // lo confugura, lo conecta a la base de datos. 
    private final  ClassEntityRepository repo; 

    public ClassEntityImpl (ClassEntityRepository repo) {
        this.repo = repo; 

    }

@Override 

public List<ClassEntityResponseDto> findAll() {
    return repo.findAll().stream().map(this::modelToDto).toList(); 
}
    @Override
    public ClassEntityResponseDto findByid(int id) {
        ClassEntity classEntity = repo.findById(id).orElse(null); 
        return classEntity !=null ? modelToDto(classEntity) : null; 
    }

    @Override
    public List<ClassEntityResponseDto> findByName(String name) {
        return repo.findByName(name).stream().map(this::modelToDto).toList(); 
    }

// vamos a combertir de DTO al model    y es un maper para poder convertir de  DTO A model ( para recordar)
public ClassEntity dtoModel(ClassEntityDto classEntityDto) {
    ClassEntity classEntity = new ClassEntity(); 
    classEntity.setName(classEntityDto.getName());
return classEntity; 

}
   // pasar de model a DTO 
   public ClassEntityResponseDto modelToDto (ClassEntity c) {
return new ClassEntityResponseDto(
    c.getId(),
    c.getName()
);
   }
@Override
    public ClassEntityResponseDto save(ClassEntityDto classEntityDto) {
        ClassEntity classEntity = dtoModel(classEntityDto);
        repo.save(classEntity);
        return modelToDto(classEntity);
   }
   @Override
   public void delete (int id) {
    repo.deleteById(id);
   }

   @Override 
   public ClassEntityResponseDto update (int id, ClassEntityDto C) {
    ClassEntity classEntity = repo.findById(id).orElse(null);
    if (classEntity == null) {
        return null; 
    }
      classEntity.setName(C.getName());

      repo.save(classEntity); 

      return modelToDto(classEntity); 

   }
}
