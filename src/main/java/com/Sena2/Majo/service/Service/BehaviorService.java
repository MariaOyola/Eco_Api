package com.Sena2.Majo.service.Service;
import java.util.List;

import com.Sena2.Majo.dto.BehaviorDto;
import com.Sena2.Majo.dto.response.BehaviorResponseDto;

public interface BehaviorService {

    List<BehaviorResponseDto>findAll(); 
    BehaviorResponseDto findByid(int id);
    List<BehaviorResponseDto> findByType (String type);
   BehaviorResponseDto save (BehaviorDto B); 

   BehaviorResponseDto update (int id, BehaviorDto B); 
   void delete (int id); 

}
