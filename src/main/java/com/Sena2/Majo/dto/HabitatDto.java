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
public class HabitatDto {
  



    @NotNull(message = "el tipo de habitat no puede ser nula")
    @Size (min = 3, max = 30, message = "el tipo de habota solo puede tener entre 3 a 30 caracteres")
    private String type; 
    @NotNull(message = "el clima del habitat no puede ser nula")
    @Size (min = 4, max = 20 , message = "el clima  de habitat  solo puede tener entre 4 a 20  caracteres")
    private String climate; 
    
    // no le voy a poner condiciones a la locacion

    @NotNull (message = "la locacion del lugar no puede ser nula")
    @Size (min = 3 , max = 15, message = "la location  de habitat  solo puede tener entre 4 a 20  caracteres")
    private String location; 



    // EN EL DTO SOLO QUIERO ENVIARLE EL ID y tipo al Usuario, ( No todo)

    
}
