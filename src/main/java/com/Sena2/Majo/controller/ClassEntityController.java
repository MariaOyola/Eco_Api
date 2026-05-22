package com.Sena2.Majo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sena2.Majo.dto.ClassEntityDto;
import com.Sena2.Majo.dto.response.ClassEntityResponseDto;
import com.Sena2.Majo.dto.view.View;
import com.Sena2.Majo.service.Service.ClassEntityService;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ClassEntity")
public class ClassEntityController {

   @Autowired
    public ClassEntityService service;


/// quiro  devolver todos los datos
    @GetMapping("")
       @JsonView(View.basic.class)
    public ResponseEntity<Object>findAll() {
        List<ClassEntityResponseDto> classEntity = service.findAll(); 
        return new ResponseEntity<>(classEntity, HttpStatus.OK); 

    }
    // pasa de cuerdo JSON Y pasarlo a un DTO de especies (muestra un mensaje)
    @PostMapping("")
       @JsonView(View.basic.class)
    public ResponseEntity<Object>save(@Valid @RequestBody ClassEntityDto C ) {
       ClassEntityResponseDto classEntity = service.save(C); 
        return new ResponseEntity<Object>(classEntity, HttpStatus.CREATED); 

    }
    // traer infirmacion porr id
@GetMapping("{id}")
   @JsonView(View.basic.class) 
public ResponseEntity<Object>findByid( @PathVariable int id) {
    ClassEntityResponseDto classEntity = service.findByid(id); 
    if (classEntity == null ) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra esta clase"); 
    }
    return new ResponseEntity<Object>(classEntity, HttpStatus.OK);
}
// Traer una lista de nombre ( en este caso de una especie)

@GetMapping("findByName/{name}") 
   @JsonView(View.basic.class)
public ResponseEntity<Object>findByName ( @PathVariable String name ) {
    List<ClassEntityResponseDto> classEntity = service.findByName(name);
    return new ResponseEntity<>(classEntity, HttpStatus.OK); 
}

@DeleteMapping ("{id}") 
   @JsonView(View.basic.class)
public ResponseEntity<Object>delete(@PathVariable int id  ) {
    service.delete(id); 
    return new ResponseEntity<Object>(" Se elimina la especie con el id", HttpStatus.OK); 
}
@PutMapping ("{id}") 
   @JsonView(View.basic.class)
public ResponseEntity<?> update (@PathVariable int id , @RequestBody ClassEntityDto C) {
    ClassEntityResponseDto update = service.update(id, C); 
    if (update == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se reconose este tipo de clase "); 


    }
    return ResponseEntity.ok(update); 
}
}

    
    
   
    
