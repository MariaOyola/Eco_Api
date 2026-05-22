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

import com.Sena2.Majo.dto.BehaviorDto;
import com.Sena2.Majo.dto.response.BehaviorResponseDto;
import com.Sena2.Majo.dto.view.View;
import com.Sena2.Majo.service.Service.BehaviorService;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/behavior")
public class BehaviorController {

    @Autowired
    public BehaviorService service;


/// quiro  devolver todos los datos
    @GetMapping("")
      @JsonView(View.detail.class)
    public ResponseEntity<Object>findAll() {
        List<BehaviorResponseDto> behavior = service.findAll(); 
        return new ResponseEntity<>(behavior, HttpStatus.OK); 

    }
    // pasa de cuerdo JSON Y pasarlo a un DTO de especies (muestra un mensaje)
    @PostMapping("")
      @JsonView(View.detail.class)
    public ResponseEntity<Object>save(@Valid @RequestBody BehaviorDto B ) {
       BehaviorResponseDto behavior = service.save(B); 
        return new ResponseEntity<Object>(behavior, HttpStatus.CREATED); 

    }
    // traer infirmacion porr id
@GetMapping("{id}") 
  @JsonView(View.detail.class)
public ResponseEntity<Object>findByid( @PathVariable int id) {
    BehaviorResponseDto behavior = service.findByid(id); 

    if (behavior == null) {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se reconoce este tipo de estado"); 
    }
    return new ResponseEntity<Object>(behavior, HttpStatus.OK);
}
// Traer una lista de nombre ( en este caso de una especie)

@GetMapping("/findByType/{type}") 
  @JsonView(View.detail.class)
public ResponseEntity<Object>findByType (@PathVariable String type) {
    List<BehaviorResponseDto> behaviors = service.findByType(type);
    return new ResponseEntity<Object>(behaviors, HttpStatus.OK); 
}

@DeleteMapping ("{id}") 
  @JsonView(View.detail.class)
public ResponseEntity<Object>delete(@PathVariable int id  ) {
    service.delete(id); 
    return new ResponseEntity<Object>(" Se elimina la especie con el id", HttpStatus.OK); 
}

@PutMapping ("/{id}")
  @JsonView(View.detail.class)
public ResponseEntity<?> update (@PathVariable int id, @RequestBody BehaviorDto B) {
    BehaviorResponseDto update = service.update(id, B); 

    if (update == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuebtra este tipo de estado"); 
    }
    return ResponseEntity.ok(update); 
}
}
