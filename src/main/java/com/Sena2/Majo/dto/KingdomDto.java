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
public class KingdomDto {

    // EN EL DTO SOLO QUIERO ENVIARLE EL  nombre al Usuario, ( No todo)
    @NotNull (message = "Debe tener un reino especifico")
    @Size (min = 3, max = 50, message = "Debe tener un reino especifico")
    private String name;
 

}
