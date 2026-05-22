package com.Sena2.Majo.service.Service;

import java.util.List;

import com.Sena2.Majo.dto.SpeciesDto;
import com.Sena2.Majo.dto.response.SpeciesResponseDto;

public interface SpeciesService {

List<SpeciesResponseDto> findAll(); // trae toda la lista de Especies por DTO 
 SpeciesResponseDto findById(int id);  // Buscar por id en DTO
 List<SpeciesResponseDto>findByName(String name); // buscar lista por nombre.
 SpeciesResponseDto save(SpeciesDto s);  // recibe request DTO 
SpeciesResponseDto update (int id, SpeciesDto s); // Actualizar por dto
void delete (int id); // eliminar por id 

     

}

 