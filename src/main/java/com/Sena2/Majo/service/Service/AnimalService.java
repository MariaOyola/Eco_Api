package com.Sena2.Majo.service.Service;
import java.util.List;

import com.Sena2.Majo.dto.AnimalDto;
import com.Sena2.Majo.dto.response.AnimalResponseDto;

public interface AnimalService {
     List<AnimalResponseDto>findAll(); 
     AnimalResponseDto  findByid (int id); 
     List<AnimalResponseDto> findByName (String name); 
     AnimalResponseDto save (AnimalDto A );
     AnimalResponseDto update (int id, AnimalDto A);  
     void  delete (int id); 



}
