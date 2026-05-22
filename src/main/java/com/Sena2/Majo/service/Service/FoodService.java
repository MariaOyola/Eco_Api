package com.Sena2.Majo.service.Service;

import java.util.List;

import com.Sena2.Majo.dto.FoodDto;
import com.Sena2.Majo.dto.response.FoodResponseDto;

public interface FoodService {
     List<FoodResponseDto> findAll(); 
     FoodResponseDto  findByid (int id); 
     List<FoodResponseDto> finByType (String type); 
    List<FoodResponseDto> findByName( String name); 
   FoodResponseDto save(FoodDto F); 
   FoodResponseDto update (int id, FoodDto F); 
    void  delete (int id); 


}
