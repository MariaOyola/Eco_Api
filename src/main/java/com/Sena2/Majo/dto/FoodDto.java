package com.Sena2.Majo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor 
public class FoodDto {

    @NotNull ( message = " el tipo de alimeto no puede ser nulo")
    private String type;
    @NotNull ( message  = " el nombre del alimento no puede ser nulo ")
        private String name;  


      

}
