package com.Sena2.Majo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sena2.Majo.dto.AnimalDto;
import com.Sena2.Majo.dto.response.AnimalResponseDto;
import com.Sena2.Majo.model.Animal;
import com.Sena2.Majo.repository.AnimalRepository;
import com.Sena2.Majo.service.Service.AnimalService;


@Service
public class AnimalImpl implements AnimalService {

    @Autowired
    private final AnimalRepository repo;

    private AnimalImpl (AnimalRepository repo) {
        this. repo = repo; 
    }


    @Override
    public List<AnimalResponseDto> findAll() {
        return repo.findAll().stream().map(this::modelToDto).toList(); 
    }

    @Override
    public AnimalResponseDto findByid(int id) {
        Animal animal = repo.findById(id).orElse(null); 
        return animal !=null ? modelToDto(animal) : null;  
    }

    @Override  
    public List<AnimalResponseDto> findByName(String name) {
        return repo.findByName(name).stream().map(this::modelToDto).toList(); 
    }

  // de DTO a MOdel 
    public Animal dtoToModel(AnimalDto animalDto) {
         Animal animal = new Animal();
         animal.setName(animalDto.getName());
         return animal; 
    }

    // de MOdel a Dto
    public AnimalResponseDto modelToDto(Animal animal) {
             return new AnimalResponseDto(
             animal.getId(), 
             animal.getName()
        );
    }

    @Override
    public AnimalResponseDto save(AnimalDto animalDto) {
        Animal animal = dtoToModel(animalDto);
        repo.save(animal);
        return modelToDto(animal); 
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);

    }

    @Override
    public AnimalResponseDto update (int id, AnimalDto A) {
        Animal animal = repo.findById(id).orElse(null); 
        if (animal == null) {
            return null; 
        }
        animal.setName(A.getName());

        repo.save(animal); 

        return modelToDto(animal); 
    }
}

