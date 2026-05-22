package com.Sena2.Majo.service.Service;

import java.util.List;

import com.Sena2.Majo.dto.LifeCycleDto;
import com.Sena2.Majo.dto.response.LifeCycleResponseDto;

public interface LiceCycleService {
   List<LifeCycleResponseDto> findAll(); 

   LifeCycleResponseDto  findById (int id); 

   List<LifeCycleResponseDto> filterByStage (String stage);

   List<LifeCycleResponseDto> findByDuration (String duration); 

  LifeCycleResponseDto save(LifeCycleDto L);

   LifeCycleResponseDto update (int id , LifeCycleDto L); 

    void delete (int id); 



}


