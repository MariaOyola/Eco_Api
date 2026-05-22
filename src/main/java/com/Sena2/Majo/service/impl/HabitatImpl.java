package com.Sena2.Majo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sena2.Majo.dto.HabitatDto;
import com.Sena2.Majo.dto.response.HabitatResponseDto;
import com.Sena2.Majo.model.Habitat;
import com.Sena2.Majo.repository.HabitatRepository;
import com.Sena2.Majo.service.Service.HabitatService;


@Service
public class HabitatImpl  implements HabitatService{

    @Autowired
    public final HabitatRepository repo; 

    public HabitatImpl (HabitatRepository repo ) {
        this.repo = repo; 
    }

    @Override
    public List<HabitatResponseDto> findAll()  {
        return repo.findAll().stream().map(this::modelToDto).toList(); 

    }


@Override
public HabitatResponseDto findByid(int id) {
    Habitat  h = repo.findById(id).orElse(null); 
    return h !=null ? modelToDto(h) : null; 
}
@Override
public List<HabitatResponseDto>findByType(String type) {
    return repo.findByType(type).stream().map(this::modelToDto).toList(); 

}
@Override 
public List <HabitatResponseDto>findByLocation (String location) {
    return repo.findByLocation(location).stream().map(this::modelToDto).toList(); 

}
@Override 
public List <HabitatResponseDto>findByClimate (String  climate) {
    return repo.findByClimate(climate).stream().map(this::modelToDto).toList(); 
}

// de DTO A model 
public Habitat dtoModel(HabitatDto habitatDto) {
Habitat habitat = new Habitat(); 
habitat.setType(habitatDto.getType());
habitat.setClimate(habitatDto.getClimate());
habitat.setLocation(habitatDto.getLocation());

return habitat; 

}
   // pasar de model a DTO 
   public HabitatResponseDto modelToDto (Habitat h) {
return new HabitatResponseDto(
    h.getId(),
    h.getType(),
    h.getClimate(),
    h.getLocation()
);
   }

@Override 
public HabitatResponseDto save (HabitatDto habitatDto) {
    Habitat habitat = dtoModel(habitatDto); 
    repo.save(habitat
    );
    return modelToDto(habitat); 

} 
@Override
public void delete (int id) {
    repo.deleteById(id);


}

// esto es lo del Update 
@Override
public HabitatResponseDto update (int id, HabitatDto H) {
    Habitat habitat = repo.findById(id).orElse(null); 
    if (habitat == null) {
        return null; 
    }

    habitat.setType(H.getType());
    habitat.setClimate(H.getClimate());
    habitat.setLocation(H.getLocation());
    repo.save(habitat); 
    return modelToDto(habitat); 
}

}
