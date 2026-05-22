package com.Sena2.Majo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sena2.Majo.dto.SpeciesDto;
import com.Sena2.Majo.dto.response.SpeciesResponseDto;
import com.Sena2.Majo.model.Species;
import com.Sena2.Majo.repository.SpeciesRepository;
import com.Sena2.Majo.service.Service.SpeciesService;



@Service
public class SpeciesImpl implements SpeciesService {

@Autowired
private final SpeciesRepository repo;

public SpeciesImpl(SpeciesRepository repo) {
    this.repo = repo;
}

@Override 
// esto significa que voya atrar los registros de la base (y esta cumpliendo con el metodo que esta sobrescribiendo)
// se va a traer ua lista
public List<SpeciesResponseDto> findAll() { 
    return repo.findAll(). // repo.findAll().  __ trae una  lista de especies desde la base de datos
    stream(). // este permite trabajar cada elemento
    map(this::modelToDto). /// este convierte de Species (que es el model) a ResponseDTO
    toList(); // este devulve una lista de DTO (informacion de la entidad), ya lista para qu eun usuario la use
}
    @Override
    public SpeciesResponseDto findById(int id) {
        Species s = repo.findById(id).orElse(null); //  orElse(null)  este es cuando no exista el Id, retorna un nulo
        return s !=null ? modelToDto(s) : null;     // si existe esto lo conviete a DTO para el usuario, 
                                                    // si no existe, devulve null ( pero en el controller manda un 404) ( no se encuenta en el servidor)
    }
   // vamos a usar el Update 

    @Override  
    public SpeciesResponseDto update (int id, SpeciesDto s) {  // buscamos  si existen exieste  el dato
        Species species = repo.findById(id).orElse(null); 
        if (species == null) {   /// si el dato es igual a nulo
            return null;    // nos  da un nulo ( osea no hay datos)
        }
            // si el dato existe
            // actualiza el dato 
            species.setName(s.getName());

            // guardae el dato
            repo.save (species); 

            // muestra la respuesta de lo guardado
            return modelToDto(species); 
        }

    

    @Override
    public List<SpeciesResponseDto> findByName(String name) { //  buscar por nombres 
        return repo.findByName(name). // trae una lista de nombres  desde la base de datos
        stream(). // trabajar con esos elementos
        map(this:: modelToDto). // convertir de Species (nombre) a un ResponseDTO
        toList(); // devolver la lista para mostrar al usuario
    }

// vamos a combertir de DTO request (DTO) al model ( no puedo guardar un dto en la base asi que toca convertirlo en la entidad)
public Species dtoModel(SpeciesDto speciesDto) {
Species s = new Species(); 
s.setName(speciesDto.getName());
return s; 

}
   // pasar de model a DTO response ( esto convierte lo guardado en la base de datos en un objeto seguro para enviar)
   public SpeciesResponseDto modelToDto (Species s) {
return new SpeciesResponseDto(
    s.getId(),
    s.getName()
);

   }
@Override
    public SpeciesResponseDto save(SpeciesDto speciesDto) {  
        Species species = dtoModel(speciesDto);
        repo.save(species); 
        return modelToDto(species);   /// esto es para que el usuario vea lo que se va a gusrdar
   }
   @Override
   public void  delete (int id) {
    repo.deleteById(id);  // elima los datos 
   }

}