package com.Sena2.Majo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.Sena2.Majo.dto.KingdomDto;
import com.Sena2.Majo.dto.response.KingdomResponseDto;
import com.Sena2.Majo.dto.view.View;
import com.Sena2.Majo.service.Service.KingdomService;
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
@RequestMapping ("/kingdom")
public class KingdomController {

    @Autowired
    private KingdomService service; 

    // ese me sirve para devolver todos los datos de una lista en este caso es todo lo de ( Reinos)
    @GetMapping("")
    @JsonView(View.basic.class)
    public ResponseEntity<Object>findAll() {
        List<KingdomResponseDto> kingdom = service.findAll()
    return new ResponseEntity<>(kingdom, HttpStatus.OK); 


    }
// este es para pasar un cuerpo JSON y pasarlo a KingdomDto// llamanos un service y se devulve un mensaje
// osea guarda un nuevo curso usando DTO
    @PostMapping("")
    @JsonView(View.basic.class)
    public ResponseEntity<Object>save( @Valid @RequestBody KingdomDto K) {
        
        KingdomResponseDto kingdom = service.save(K); 
        return new ResponseEntity<Object>(kingdom,HttpStatus.CREATED); 

    }
    // aqui se trae toda la informacion por id
    @GetMapping("{id}")
    @JsonView(View.basic.class)
    public ResponseEntity<Object>findByid(@PathVariable int id) {
        KingdomResponseDto kingdom = service.findById(id);

        if (kingdom == null) {      // el NOT_FOUND es p<r< eviar un error cuaando no existe el id 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("este reino no se encuentra");  
        }
    
        return new ResponseEntity<Object>(kingdom, HttpStatus.OK); 
    }

    // traer una lista de nombre (Nombre del reino)
    @GetMapping("filterByName/{name}")
  @JsonView(View.basic.class)
    public ResponseEntity<Object>filterByName(@PathVariable String name) {
        List<KingdomResponseDto> kingdoms= service.filterByName(name); 

        return new ResponseEntity<>(kingdoms, HttpStatus.OK); 
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
    public ResponseEntity<?> update (@PathVariable int id, @Valid @RequestBody KingdomDto K) {
          KingdomResponseDto update = service.update(id, K); 
          if (update == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" este reino no existe");
          }  
          return ResponseEntity.ok(update);

    }

    }
    

    
    
    
