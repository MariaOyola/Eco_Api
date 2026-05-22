package com.Sena2.Majo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BehaviorDto {
    
    @NotNull ( message = " el tipo de comportamiento no puede ser nulo ") 
    private String type;
    
    

    
    

}
