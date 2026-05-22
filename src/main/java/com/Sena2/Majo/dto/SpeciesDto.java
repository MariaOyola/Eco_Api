package com.Sena2.Majo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpeciesDto {

 
    @NotNull ( message = "  El animal debe tener una especie ")
    @Size (min = 3, max = 30, message =  " La especie debe tener entre 3  y 30 caracteres")
    private String name; 
  


}
