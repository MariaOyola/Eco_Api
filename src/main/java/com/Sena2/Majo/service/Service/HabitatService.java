package com.Sena2.Majo.service.Service;
import java.util.List;

import com.Sena2.Majo.dto.HabitatDto;
import com.Sena2.Majo.dto.response.HabitatResponseDto;


public interface HabitatService {

List<HabitatResponseDto> findAll(); 
HabitatResponseDto findByid (int id); 
 List<HabitatResponseDto> findByType(String type); 
 List<HabitatResponseDto> findByLocation (String location); 
 List<HabitatResponseDto> findByClimate (String climate); 
 HabitatResponseDto save (HabitatDto H); 
 HabitatResponseDto update (int id, HabitatDto H); 
void  delete (int id); 

}
