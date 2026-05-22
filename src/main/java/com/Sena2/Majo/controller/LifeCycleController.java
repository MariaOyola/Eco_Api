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

import com.Sena2.Majo.dto.LifeCycleDto;
import com.Sena2.Majo.dto.response.LifeCycleResponseDto;
import com.Sena2.Majo.dto.view.View;
import com.Sena2.Majo.service.Service.LiceCycleService;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/LifeCycle")
public class LifeCycleController {

    @Autowired
    public LiceCycleService service; 

    @GetMapping("") 
    @JsonView(View.basic.class)
    public ResponseEntity<Object>findAll () {
        List<LifeCycleResponseDto> lifecycle = service.findAll(); 
        return new ResponseEntity<>(lifecycle ,HttpStatus.OK); 
    }
    @PostMapping ("") 
    @JsonView(View.basic.class)
    public ResponseEntity<Object>save( @Valid @RequestBody LifeCycleDto L ) {
       LifeCycleResponseDto  lifecycle =  service.save(L); 
        return new ResponseEntity<Object>(lifecycle, HttpStatus.CREATED); 

    }
@GetMapping("{id}") 
 @JsonView(View.basic.class)
public ResponseEntity<Object>findById(@PathVariable int id) {
    LifeCycleResponseDto lifeCycle = service.findById(id); 
if (lifeCycle == null) {          // este tiene erro  404 ( NO se encuentra este dato)
 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("este ciclo de vida  no se encuentra"); 
}
    return new ResponseEntity<Object>(lifeCycle, HttpStatus.OK); 

}
@GetMapping ("filterByStage/{stage}") 
@JsonView(View.basic.class)
public ResponseEntity<Object>finByStage (@PathVariable String  stage ) {
    List<LifeCycleResponseDto> lifeCycles = service.filterByStage(stage); 
    return new ResponseEntity<>(lifeCycles, HttpStatus.OK); 
}
@GetMapping ("filterByDuratin/{duration}")
 @JsonView(View.basic.class)
public ResponseEntity<Object>filterByDuratin (@PathVariable String duration) {
    List<LifeCycleResponseDto> lifeCycles = service.findByDuration(duration); 
    return new ResponseEntity<>(lifeCycles, HttpStatus.OK); 
}

@DeleteMapping ("{id}")
  @JsonView(View.basic.class)
public ResponseEntity<Object>delete(@PathVariable int id  ) {
    service.delete(id); 
    return new ResponseEntity<Object>(" Se elimina la especie con el id", HttpStatus.OK); 
}

@PutMapping ("/{id}")
 @JsonView(View.basic.class)
public ResponseEntity<Object> update (@PathVariable int id, @RequestBody LifeCycleDto L) {
    LifeCycleResponseDto update = service.update(id, L); 
    if (update == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("este ciclo de vida  no se encuentra"); 
    }
    return ResponseEntity.ok(update); 
}
}
