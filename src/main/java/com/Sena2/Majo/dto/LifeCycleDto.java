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
public class LifeCycleDto {


    @NotNull ( message = "etapa es obligatoria")
    @Size (min = 3, max = 50, message =  " La etapa ddebe tener entr 3 y  50 caracteres")
    private String stage;

   @NotNull ( message = "duracion es obligatoria")
    @Size (min = 3, max = 50, message =  " La  duracion ddebe tener entr 3 y  50 caracteres")
    private  String  duration;



}
