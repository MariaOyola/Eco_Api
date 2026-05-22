package com.Sena2.Majo.dto.response;
import com.Sena2.Majo.dto.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodResponseDto {

    @JsonView(View.basic.class)
    private Integer id;

    @JsonView(View.basic.class)
    private String name;

    @JsonView(View.basic.class)
    private String type;
    

}
