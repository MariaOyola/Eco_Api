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
import com.Sena2.Majo.dto.FoodDto;
import com.Sena2.Majo.dto.response.FoodResponseDto;
import com.Sena2.Majo.dto.view.View;
import com.Sena2.Majo.service.Service.FoodService;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/food")
public class FoodController {

 @Autowired
    public FoodService service;


/// quiro  devolver todos los datos
    @GetMapping("")
       @JsonView(View.basic.class)
    public ResponseEntity<Object>findAll() {
        List<FoodResponseDto> food = service.findAll(); 
        return new ResponseEntity<Object>(food, HttpStatus.OK); 

    }
    // pasa de cuerdo JSON Y pasarlo a un DTO de especies (muestra un mensaje)
    @PostMapping("")
       @JsonView(View.basic.class)
    public ResponseEntity<Object>save(@ Valid @RequestBody FoodDto F ) {
       FoodResponseDto food =  service.save(F); 
        return new ResponseEntity<Object>(food, HttpStatus.CREATED); 

    }
    // traer infirmacion porr id
@GetMapping("{id}") 
   @JsonView(View.basic.class)
public ResponseEntity<Object>findByid( @PathVariable int id) {
    FoodResponseDto food = service.findByid(id); 
     if (food == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se encuentra este tipo de alimento"); 
     }
    return new ResponseEntity<Object>(food, HttpStatus.OK);
}
// Traer una lista de nombre ( en este caso de una especie)

@GetMapping("finByType/{type}") 
   @JsonView(View.basic.class)
public ResponseEntity<Object>finByType (@PathVariable String type) {
    List<FoodResponseDto> food = service.finByType(type);
    return new ResponseEntity<>(food, HttpStatus.OK); 
}

@GetMapping ("findByName/{name}")
   @JsonView(View.basic.class)
public ResponseEntity<Object>findByName (@PathVariable String name) {
    List<FoodResponseDto> food = service.findByName(name); 
    return new ResponseEntity<>(food, HttpStatus.OK); 
}

@DeleteMapping ("{id}")
   @JsonView(View.basic.class) 
public ResponseEntity<Object>delete(@PathVariable int id  ) {
    service.delete(id); 
    return new ResponseEntity<Object>(" Se elimina la especie con el id", HttpStatus.OK); 
}
@PutMapping ("/{id}")
   @JsonView(View.basic.class)
public ResponseEntity<Object> update (@PathVariable int id, @RequestBody FoodDto F) {
   FoodResponseDto update = service.update(id, F); 
   if (update == null) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuestra  este dato"); 
   } 
   return ResponseEntity.ok(update); 
}

}
