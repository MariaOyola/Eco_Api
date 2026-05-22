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

import com.Sena2.Majo.dto.AnimalDto;
import com.Sena2.Majo.dto.response.AnimalResponseDto;
import com.Sena2.Majo.dto.view.View;
import com.Sena2.Majo.service.Service.AnimalService;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Animal")
public class AnimalController {
    
@Autowired
    private AnimalService service; 

    // ese me sirve para devolver todos los datos de una lista en este caso es todo lo de ( Reinos)
    @GetMapping("")
 @JsonView(View.basic.class)
    public ResponseEntity<Object>findAll() {
        List<AnimalResponseDto> Animal = service.findAll()
        return new ResponseEntity<> (Animal, HttpStatus.OK); 


    }
// este es para pasar un cuerpo JSON// llamanos un service y se devulve un mensaje
// osea guarda un nuevo curso usando DTO
    @PostMapping("")
     @JsonView(View.basic.class)
    public ResponseEntity<Object>save( @Valid @RequestBody AnimalDto A) {
       AnimalResponseDto animal = service.save(A); 
        return new ResponseEntity<Object>(animal, HttpStatus.CREATED); 

    }
    // aqui se trae toda la informacion por id
    @GetMapping("{id}")

    public ResponseEntity<Object>findByid(@PathVariable int id) {
        AnimalResponseDto animal = service.findByid(id);
        
        if (animal == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra este tipo de Animal"); 
        }
        return new ResponseEntity<Object>(animal, HttpStatus.OK); 
    }

    // traer una lista de nombre (Nombre del reino)
    @GetMapping("findByName/{name}")
     @JsonView(View.basic.class)
    public ResponseEntity<Object> findByName(@PathVariable String name) {
        List<AnimalResponseDto> animals = service. findByName(name); 
        return new ResponseEntity<>(animals, HttpStatus.OK); 

    }

     // Eliminaar por id
    @DeleteMapping("{id}") 
     @JsonView(View.basic.class)
    public ResponseEntity<Object>delete(@PathVariable int id ) {
        service.delete(id); 
        return new ResponseEntity<Object>("Se elimina",HttpStatus.OK); 
    }
    @PutMapping ("/{id}")
     @JsonView(View.basic.class)
    public ResponseEntity<Object> update (@PathVariable int id, @RequestBody AnimalDto A) {
      AnimalResponseDto update = service.update(id, A); 
      
      if (update == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encueetra este tipo de animal"); 
      }
      return ResponseEntity.ok(update); 
    }

    }
    
