package com.Sena2.Majo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sena2.Majo.dto.FoodDto;
import com.Sena2.Majo.dto.response.FoodResponseDto;
import com.Sena2.Majo.model.Food;
import com.Sena2.Majo.repository.FoodRepository;
import com.Sena2.Majo.service.Service.FoodService;


@Service
public class FoodImpl implements FoodService{


 @Autowired
    public final FoodRepository repo; 

    public FoodImpl (FoodRepository repo) {
        this.repo = repo; 
    }

    @Override
    public List<FoodResponseDto> findAll() {
        return repo.findAll().stream().map(this::modelToDto).toList();  
    }

@Override
public FoodResponseDto findByid(int id) {
    Food F = repo.findById(id).orElse(null); 
    return F !=null ? modelToDto(F):null; 
     
}
@Override
public List<FoodResponseDto>finByType(String type) {
    return repo.findByType(type).stream().map(this::modelToDto).toList();  

}

@Override 
public List<FoodResponseDto> findByName( String name) {
    return repo.findByName(name).stream().map(this::modelToDto).toList(); 

}
// de DTO A model 
public Food dtoModel(FoodDto foodDto) {
    Food food = new Food(); 
    food.setType(foodDto.getType());
    food.setName(food.getName());
    return food; 
}
   // pasar de model a DTO 
   public FoodResponseDto modelToDto (Food f) {
return new FoodResponseDto(
    f.getId(),
    f.getType(),
    f.getName()
);
   }

@Override 
public FoodResponseDto save (FoodDto foodDto) {
    Food food = dtoModel(foodDto); 
    repo.save(food
    );
    return modelToDto(food); 

} 
@Override
public void delete (int id) {
    repo.deleteById(id);
}
@Override 
public FoodResponseDto update (int id, FoodDto F) {
    Food food = repo.findById(id).orElse(null); 
    if (food == null)  {
        return null; 

    }

    food.setName(F.getName());
    food.setType(F.getType());

    repo.save(food); 
    return modelToDto(food); 
}
}
