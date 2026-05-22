package com.Sena2.Majo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sena2.Majo.dto.BehaviorDto;
import com.Sena2.Majo.dto.response.BehaviorResponseDto;
import com.Sena2.Majo.model.Behavior;
import com.Sena2.Majo.repository.BehaviorRepository;
import com.Sena2.Majo.service.Service.BehaviorService;


@Service
public class BehaviorImplService implements BehaviorService  {

    @Autowired
    private final BehaviorRepository repo;

    private  BehaviorImplService (BehaviorRepository repo) {
        this.repo = repo; 
    }

    @Override
    public List<BehaviorResponseDto> findAll() {
        return repo.findAll().stream().map(this::modelToDto).toList(); 
    }

    @Override
    public BehaviorResponseDto findByid(int id) {
        Behavior behavior = repo.findById(id).orElse(null); 
        return behavior !=null ? modelToDto(behavior):null;  
    }

    @Override
    public List<BehaviorResponseDto> findByType(String type) {
        return repo.findByType(type).stream().map(this::modelToDto).toList(); 
    }
     // DTO → Model
public Behavior dtoModel(BehaviorDto behaviorDto) {
Behavior behavior = new Behavior(); 
behavior.setType(behaviorDto.getType());
return behavior; 

    }

    // Model → DTO
    public BehaviorResponseDto modelToDto(Behavior behavior) {
        return new  BehaviorResponseDto(
            behavior.getId(),
            behavior.getType()
        );
    }

    @Override
    public BehaviorResponseDto save(BehaviorDto behaviorDto) {
        Behavior behavior = dtoModel(behaviorDto);
        repo.save(behavior);
        return modelToDto(behavior);
    }

    @Override
    public void delete (int id) {
        repo.deleteById(id);
    }

    @Override 
    public  BehaviorResponseDto update (int id, BehaviorDto B) {
     Behavior behavior = repo.findById(id).orElse(null); 
     if (behavior == null) {
        return null; 

     }
     
     behavior.setType(B.getType());
     repo.save(behavior); 
     return modelToDto(behavior); 
    }
}
