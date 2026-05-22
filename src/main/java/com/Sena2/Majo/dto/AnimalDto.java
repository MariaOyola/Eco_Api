package com.Sena2.Majo.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;


// Esta  clases son las que principalmente el usuario usa para enviar datos al POST

@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDto {
    
    @NotBlank ( message =  " no permite datos ni nulos ni vacios")
    @Size (min = 3, max = 20,  message = "el nombre del animaal debe tener por lo menos de 3 a 20 carateres ")
    private String name;




}