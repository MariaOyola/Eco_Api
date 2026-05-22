package com.Sena2.Majo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.Sena2.Majo.dto.SpeciesDto;
import com.Sena2.Majo.dto.response.SpeciesResponseDto;
import com.Sena2.Majo.dto.view.View;
import com.Sena2.Majo.service.Service.SpeciesService;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 


@RestController
@RequestMapping("/Species")

public class SpeciesController {

    @Autowired
    public SpeciesService service;


/// quiro  devolver todos los datos
    @GetMapping("")
    @JsonView(View.basic.class)
    public ResponseEntity<Object>findAll() {
        List<SpeciesResponseDto> species  = service.findAll(); 
        return new ResponseEntity<>(species, HttpStatus.OK); 

    }
    // pasa de cuerdo JSON Y pasarlo a un DTO de especies (muestra un mensaje)
    @PostMapping("")
    @JsonView(View.basic.class)
    public ResponseEntity<Object>save(@Valid @RequestBody SpeciesDto s ) {
       SpeciesResponseDto species = service.save(s); 
        return new ResponseEntity<Object>(species, HttpStatus.CREATED); 

    }
    // traer infirmacion porr id

@GetMapping("{id}") 
 @JsonView(View.basic.class)
public ResponseEntity<Object>findById( @PathVariable int id) {
    SpeciesResponseDto species = service.findById(id); 
    if (species == null) {   // si no se encuentra por el id
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("este especie no se encuentra"); //  no se encuentra  nulo 
            }
    return new ResponseEntity<Object>(species, HttpStatus.OK);
}
// Traer una lista de nombre ( en este caso de una especie)

@GetMapping("filterByName/{name}") 
@JsonView(View.basic.class)
public ResponseEntity<Object>filterByName ( @PathVariable String name ) {
    List<SpeciesResponseDto> species = service.findByName(name);
    return new ResponseEntity<>(species, HttpStatus.OK); 
}

@DeleteMapping ("{id}") 
 @JsonView(View.basic.class)
public ResponseEntity<Object>delete(@PathVariable int id  ) {
    service.delete(id); 
    return new ResponseEntity<Object>(" Se elimina la especie con el id", HttpStatus.OK); 
}
@PutMapping ("/{id}")

 @JsonView(View.basic.class)
public ResponseEntity<?> update (@PathVariable int id, @RequestBody SpeciesDto s) {
    SpeciesResponseDto update =service.update(id, s); 
    if (update == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("este especie no se encuentra"); 

    }
    return ResponseEntity.ok(update); 
}
}

    
    
   
    

