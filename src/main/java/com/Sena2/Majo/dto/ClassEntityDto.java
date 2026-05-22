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
public class ClassEntityDto {

    @NotNull(message =  "la clase de aanimal no puede ser nula")
    @Size(min = 3, max = 20, message = "el nombre solo debe tener  de 3 a 20 caracteres")
    private String  name; 



    // EN EL DTO SOLO QUIERO ENVIARLE EL ID y nombre al Usuario, ( No todo)




}
