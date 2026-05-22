package com.Sena2.Majo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sena2.Majo.dto.LifeCycleDto;
import com.Sena2.Majo.dto.response.LifeCycleResponseDto;
import com.Sena2.Majo.model.LifeCycle;
import com.Sena2.Majo.repository.LifeCycleRepository;
import com.Sena2.Majo.service.Service.LiceCycleService;


@Service
public class LiceCycleImpl implements LiceCycleService {

  @Autowired
  private final LifeCycleRepository repo;

  public LiceCycleImpl (LifeCycleRepository repo) {
    this.repo = repo; 
  }

  // voy trar toda la lista por DTO 
@Override
public List<LifeCycleResponseDto> findAll() {
    return repo.findAll().  ///  traer todas la lista de ciclo de vida
    stream().  // trabaja con el elemento 
    map(this::modelToDto). // convierte de Model a dto
    toList(); // devulve una Lista al DTO
}


@Override
public LifeCycleResponseDto  findById(int id) {  // buscamos por id, si no existe devolvemos null
    LifeCycle L = repo.findById(id).orElse(null); 
    return L !=null ? modelToDto(L) : null; 
}
@Override
public List<LifeCycleResponseDto> filterByStage (String stage) {  //  buscamos lista  
    return repo.filterByStage(stage). // traemos la lista 
    stream().map(this::modelToDto). // convertir de model a dto
    toList(); // devolver la lista ya lista al usuario 

}

@Override 
public  List<LifeCycleResponseDto> findByDuration ( String duration) {
    return repo.findByDuration(duration).
    stream().map(this::modelToDto).toList(); 
}
   // pasar de DTO  a Model
public LifeCycle dtoModel(LifeCycleDto lifeCycleDto) {
  LifeCycle L = new LifeCycle(); 
  L.setStage(lifeCycleDto.getStage());
  L.setDuration(lifeCycleDto.getDuration());
  return L; 
}
   // pasar de model a DTO 
   public LifeCycleResponseDto modelToDto (LifeCycle L) {
return new LifeCycleResponseDto(
    L.getId(), 
    L.getStage(),
     L.getDuration()
    ); 
   }

@Override 
 public LifeCycleResponseDto save (LifeCycleDto lifeCycleDto) {
    LifeCycle lifeCycle = dtoModel(lifeCycleDto); 
    repo.save(lifeCycle);
    return modelToDto(lifeCycle); 

} 
@Override
public void delete (int id) {
    repo.deleteById(id);
}

@Override 
public LifeCycleResponseDto update (int id, LifeCycleDto L ) { //Buscamos para actualizar por id
    LifeCycle lifeCycle = repo.findById(id).orElse(null); 
    if (lifeCycle == null) { // si el dato  no existe
        return null; // el valor es nulo
    }
    // si el dato si existe
    // actualiza el dato
     lifeCycle.setStage(L.getStage());
     lifeCycle.setDuration(L.getDuration());

     // guardar el dato
     repo.save(lifeCycle); 

     // muestra la respuesta de dato guardado
     return modelToDto(lifeCycle); 

}
}

