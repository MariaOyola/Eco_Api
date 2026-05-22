package com.Sena2.Majo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sena2.Majo.dto.KingdomDto;
import com.Sena2.Majo.dto.response.KingdomResponseDto;
import com.Sena2.Majo.model.Kingdom;
import com.Sena2.Majo.repository.KingdomRepository;
import com.Sena2.Majo.service.Service.KingdomService;

@Service
public class KingdomImpl implements  KingdomService{

    @Autowired  // este lo que hace es crear un tipo de objeto sin necesidad de intranciar con new
    // lo confugura, lo conecta a la base de datos. 
    private final KingdomRepository repo; 

    private KingdomImpl (KingdomRepository repo ) {
        this.repo = repo; 
    }


@Override 

public List<KingdomResponseDto> findAll() {
    return repo.findAll().stream().map(this::modelToDto).toList(); 
}
    @Override
    public KingdomResponseDto  findById(int id) {
           Kingdom k = repo.findById(id).orElse(null);
           return k !=null ? modelToDto(k) : null; 
    }

    @Override
    public List<KingdomResponseDto> filterByName(String name) {
        return repo.filterByName(name).stream().map(this::modelToDto).toList(); 
    }

// vamos a combertir de DTO al model
public Kingdom dtoModel(KingdomDto kingdomDto) {
    Kingdom K = new Kingdom(); 
    K.setName(kingdomDto.getName());
    return K; 
}
   // pasar de model a DTO 
   public KingdomResponseDto modelToDto (Kingdom k) {
    return new KingdomResponseDto(
        k.getId(), 
        k.getName()
    ); 
   }  
   
@Override
    public KingdomResponseDto save(KingdomDto kingdomDto) {
        Kingdom kingdom = dtoModel(kingdomDto);
        repo.save(kingdom);
        return modelToDto(kingdom);
   }
   @Override
   public void  delete (int id) {
    repo.deleteById(id);

   }

   @Override
   public KingdomResponseDto update (int id, KingdomDto K) {

   Kingdom kingdom = repo.findById(id).orElse(null); 
   if (kingdom == null) {
    return null; 
   }
   kingdom.setName(K.getName());

   repo.save(kingdom); 

   return modelToDto(kingdom); 
}
}

